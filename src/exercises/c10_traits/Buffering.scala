package exercises.c10_traits
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.io.InputStream

trait Buffering extends InputStream with Logger {
  val buffIn = new BufferedInputStream(this)
  
  override def read(): Int = {
    val b = buffIn.read()
    if (b != -1) log("Read byte %02X (%s)".format(b, b.asInstanceOf[Char]))
    else log("Read EOF")
    b
  }
}

object BufferingApp extends App {
  val fis = new FileInputStream("spaces.txt") with MyConsoleLogger with Buffering
  var b: Int = _
  
  while ( {b = fis.read(); b} != -1 ) {
    //print(b.asInstanceOf[Char])
  }
}