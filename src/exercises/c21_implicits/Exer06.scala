// Exer06
package exercises.c21_implicits
import java.awt.Point

class RichPointLex(xC: Int, yC: Int) extends Point(xC, yC) with Ordered[Point] {
  override def toString = "" + (x, y)
  
  def compare(that: Point) =
      toString.compare((new RichPointLex(that.x, that.y)).toString)
}

object Exer06 extends App {
  // In order to test comment point2Double from the package object.
  val p1 = new Point(1, 3)
  val p2 = new Point(1, 2)
  val p3 = new Point(2, 1)
  println( p1 > p2 )
  println( p1 < p3 )
  println( p2 > p3 )
}