// Exer01
// Exer02
package exercises.c22_continuations
import scala.util.continuations._

object OpenFile extends App {
  var cont: (String => Unit) = null
  var filename = "/tmp/myfile.txt"
  var contents = ""

  reset {
    while (contents == "") {
      try {
        contents = io.Source.fromFile(filename, "UTF-8").mkString
      } catch { case _: Throwable => }

      filename = shift { k: (String => Unit) =>
        cont = k
      }
    }
  }

  if (contents == "") {
    print("Try another file: ")
    val fn = readLine()
    cont(fn)
  }
  println(contents)
}

// vim: set ts=4 sw=4 et:
