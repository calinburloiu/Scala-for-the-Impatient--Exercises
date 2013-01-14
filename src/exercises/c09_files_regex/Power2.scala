package exercises.c09_files_regex
import java.io.PrintWriter
import math.pow

object Power2 extends App {
  val writer = new PrintWriter("power2.txt")
  val p2 = (x: Double) => pow(2.0, x)
  val p2r = (x: Double) => pow(2.0, -x)
  for (i <- 0 to 20) {
    writer.println("" + p2(i) + "\t" + p2r(i))
  }
  writer.close
}