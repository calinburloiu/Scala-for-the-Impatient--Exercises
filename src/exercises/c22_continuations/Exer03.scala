// Exer03
package exercises.c22_continuations
import scala.util.continuations._
import java.io.File

class FileIterator(startDir: File) extends Iterator[File] {
  var cont: Unit => Unit = null
  private var _hasNext = true
  private var _finished = false
  private var _crtFile: File = null

  reset {
    processDirectory(startDir)
  }

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

        _crtFile = f
      }
    }
    _finished = true
  }

  def hasNext = _hasNext

  def next() = {
    cont()
    if (_hasNext) {
      if (_finished)
        _hasNext = false
      _crtFile
    } else
      throw new java.util.NoSuchElementException("next on empty iterator")
  }
}

object Exer03 extends App {
  val fit = new FileIterator(new File(args(0)))
  for (i <- 1 to args(1).toInt) {
    if (fit.hasNext)
      println(fit.next())
  }
}

// vim: set ts=4 sw=4 et:
