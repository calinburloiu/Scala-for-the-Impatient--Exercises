// Exer04
package exercises.c09_files_regex
import scala.io.Source

object Floats extends App {
  val checkFloat = (s: String) => {
    try {
      s.toFloat
      true
    } catch {
      case e: NumberFormatException => false
    }
  } 
  val a = Source.fromFile("floats.txt").mkString.split("[ \n\t]+").filter(checkFloat).
      map(_.toFloat)
  println(a.mkString(" "))
  println(a.sum)
  println(a.sum / a.count((Float) => true))
  println(a.min)
  println(a.max)
  
}