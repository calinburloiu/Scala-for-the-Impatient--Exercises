// Exer02
package exercises.c09_files_regex
import scala.io.Source
import java.io.PrintWriter

object TabReplacer extends App {
  val tabWidth = 8
  val lineIt = Source.fromFile("tabs.txt").getLines
  var mutLine: StringBuilder = _
  var writer = new PrintWriter("spaces.txt")
  var i: Int = _
  
  for (line <- lineIt) {
    mutLine = new StringBuilder(line)
    
    do {
      i = mutLine.indexOf("\t", i + 1)
      if (i != -1)
        mutLine.replace(i, i + 1, " " * (tabWidth - i % tabWidth))
    } while (i != -1)
    
    writer.println(mutLine)
  }
  
  writer.close()
}