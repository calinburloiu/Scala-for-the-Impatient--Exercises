package test
import scala.util.continuations._
import java.io.File

object DirsContinuation extends App {
  var cont: Unit => Unit = null

  def processDirectory(dir: File): Unit @cps[Unit] = {
    val files = dir.listFiles

    var i = 0
    while (i < files.length) {
      val f = files(i)
      i += 1

      if (f.isDirectory) {
        processDirectory(f)
      } else {
        shift {
          k: (Unit => Unit) => {
            cont = k
          }
        }
        println(f)
      }
    }
  }

  reset {
    processDirectory(new File("/home"))
  }

  for (i <- 1 to 10) {
    cont()
  }
}


// vim: set ts=4 sw=4 et:
