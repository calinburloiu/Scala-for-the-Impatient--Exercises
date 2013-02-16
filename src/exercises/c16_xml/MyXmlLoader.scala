package exercises.c16_xml
import org.xml.sax.ext.DefaultHandler2
import javax.xml.parsers.SAXParserFactory
import javax.xml.parsers.SAXParser
import scala.xml.XML
import scala.xml.Elem
import scala.xml.dtd.DocType
import scala.xml.dtd.PublicID

class MyXmlLoader(filename: String) {
  val source = xml.Source.fromFile(filename)
  var name: String = _
  var publicId: String = _
  var systemId: String = _
  var doc: Elem = _
  
  val handler = new DefaultHandler2 {
    override def startDTD(name: String, publicId: String, systemId: String) {
      MyXmlLoader.this.name = Option(name).getOrElse("")
      MyXmlLoader.this.publicId = Option(publicId).getOrElse("")
      MyXmlLoader.this.systemId = Option(systemId).getOrElse("")
    }
  }
  
  def parser: SAXParser = {
    val p = SAXParserFactory.newInstance.newSAXParser
    p.setProperty("http://xml.org/sax/properties/lexical-handler", handler)
    p
  }
  
  def loadXml() {
    doc = XML.loadXML(source, parser)
  } 
  
  def saveXml(outFilename: String) {
    val dt = DocType(name, PublicID(publicId, systemId), Nil)
    XML.save(outFilename, doc, enc = "UTF-8", xmlDecl = true, doctype = dt)
  }
}