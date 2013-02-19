// Exer10
package exercises.c10_traits
import java.io.InputStream
import java.io.FileInputStream

trait IterableInputStream extends InputStream with Iterable[Byte] {
  def iterator = new Iterator[Byte] {
    def hasNext = if (available > 0) true else false
    
    def next = read().asInstanceOf[Byte]
  }
}

object IterableApp extends App {
  val fis = new FileInputStream("ascii.txt") with IterableInputStream
  
  for (i <- fis) print(i.asInstanceOf[Char])
}