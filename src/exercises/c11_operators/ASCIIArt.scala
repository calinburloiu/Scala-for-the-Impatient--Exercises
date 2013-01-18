package exercises.c11_operators

object ASCIIArt {
  
  def apply(name: String) = new ASCIIArt(io.Source.fromFile(name + ".txt").mkString)

}

class ASCIIArt(fig: String) {
  override val toString = fig
  
  def *(that: ASCIIArt): ASCIIArt = {
    val linesA = this.toString.split("\n")
    val linesB = that.toString.split("\n")
    val linesCount = math.max(linesA.length, linesB.length)
    var buf = new String
    
    for (i <- 0 until linesCount) {
      if (i < linesA.length)
        buf += linesA(i) + "  "
      if (i < linesB.length)
        buf += linesB(i)
      buf += "\n"
    }
    
    new ASCIIArt(buf)
  }
  
  def +(that: ASCIIArt): ASCIIArt = new ASCIIArt(this.toString + "\n\n" + that.toString)
}
