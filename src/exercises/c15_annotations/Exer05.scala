// Exer05
package exercises.c15_annotations
import scala.io.Source

object FileReader {
  def getStringFromFile(fileName: String) = Source.fromFile(fileName).mkString
}
