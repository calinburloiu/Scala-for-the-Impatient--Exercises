// Exer07
package exercises.c21_implicits
import java.awt.Point

object Exer07 extends App {
  // In order to test comment point2RichPointLex from the package object.
  val p1 = new Point(1, 3)
  val p2 = new Point(1, 2)
  val p3 = new Point(2, 1)
  println( p1 > p2 )
  println( p1 < p3 )
  println( p2 > p3 )
  println( p2 < p3 )
}
