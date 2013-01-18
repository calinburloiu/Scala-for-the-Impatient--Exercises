package exercises.c11_operators

object RichFile {
  def unapply(f: RichFile) = {
    val fn = f.toString
    val slash = fn.lastIndexOf("/")
    val dot = fn.lastIndexOf(".")
    Some((fn.substring(0, slash+1), fn.substring(slash+1, dot), fn.substring(dot+1)))
  }
  
  def unapplySeq(f: RichFile) = Some(f.toString.split("/"))
}

class RichFile(fileName: String) {
  override val toString = fileName
  
  def unapply(f: RichFile) = {
    val fn = f.toString
    val slash = fn.lastIndexOf("/")
    val dot = fn.lastIndexOf(".")
    Some((fn.substring(0, slash+1), fn.substring(slash+1, dot), fn.substring(dot+1)))
  }
  
  def unapplySeq(f: RichFile) = Some(f.toString.split("/"))
}