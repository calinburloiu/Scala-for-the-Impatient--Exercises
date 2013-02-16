package exercises
import xml._
import scala.xml.parsing.XhtmlParser
import scala.xml.dtd.DocType

package object c16_xml {
  // Exer02
  def exer02Text {
    val x = <ul>
        <li>Opening bracket: [</li>
        <li>Closing bracket: ]</li>
        <li>Opening brace: {{</li>
        <li>Closing brace: }}</li>
      </ul>
  }
  
  // Exer03
  def exer03 {
    <li>Fred</li> match { case <li>{Text(t)}</li> => t }
    
    // This generates an Atom[String].
    <li>{"Fred"}</li> match { case <li>{t: Atom[_]}</li> => t }
  }
  
  // Exer04
  def printImgsWithoutAlt(filename: String) {
    val parser = new XhtmlParser(io.Source.fromFile(filename))
    val root = parser.initialize.document.docElem
    val imgs = root \\ "img"
    for (img <- imgs if img.attributes.get("alt") == None) {
      println(img)
    }
  }
  
  // Exer05
  def printSrcOfImgs(filename: String) {
    val parser = new XhtmlParser(io.Source.fromFile(filename))
    val root = parser.initialize.document.docElem
    val imgs = root \\ "img"
    for (img <- imgs if img.attributes.get("src") != None) {
      println(img.attributes("src"))
    }
  }
  
  // Exer06
  def printLinks(filename: String) {
    val parser = new XhtmlParser(io.Source.fromFile(filename))
    val root = parser.initialize.document.docElem
    val anchors = root \\ "a"
    
    def toText(n: Node) = n match {
      case x: Text => x.toString
      case _ => " "
    }
    
    for (anchor <- anchors if anchor.attributes.get("href") != None) {
      val text = anchor.child.map(toText).reduceLeft(_ + _)
      println(text + "\t" + anchor.attributes("href"))
    }
  }
  
  // Exer07
  def makeHtmlDl(map: Map[String, String]): Elem = {
    val items = for (i <- map)
      yield { <xml:group><dt>{i._1}</dt><dd>{i._2}</dd></xml:group> }
    <dl>{items}</dl>
  }
  
  // Exer08
  def makeMapFromDl(dl: Elem): Map[String, String] = {
    val dts = (dl \ "dt").map { _.child(0).toString }
    val dds = (dl \ "dd").map { _.child(0).toString }
    dts.zip(dds).toMap
  }
  
  // Exer09
  // Exer10
  /* Use MyXmlLoader for preserving the DOCTYPE.
   * It does not use a local resolver for the DTD, so loading XHTML file can
   * take some time and it may even fail on network timeout.
   */
  def addAlts2Html(filename: String) {
    import RichNode.node2RichNode
    
    val parser = new XhtmlParser(io.Source.fromFile(filename))
    val doc = parser.initialize.document
    val root = doc.docElem
    
    val rule = (n: Node) => n match {
      case x @ <img>{_*}</img> if x.attributes.get("alt") == None =>
        x.asInstanceOf[Elem] % Attribute(null, "alt", "TODO", scala.xml.Null)
      case _ => n
    }
    
    val transformed = root.transform(rule)(0)
    XML.save("out.xhtml", transformed, enc = "UTF-8",
        xmlDecl = true)
  }
}