package exercises.c10_traits
import _root_.java.awt.Point
import scala.collection.immutable.TreeSet

class OrderedPoint(initX: Int, initY: Int)
  extends Point(initX, initY) with math.Ordered[Point] {
  
  def compare(that: Point): Int = {
    if (this.getX != that.getX) (this.getX - that.getX).asInstanceOf[Int]
    else {
      if (this.getY != that.getY) (this.getY - that.getY).asInstanceOf[Int]
      else 0
    }
  }
}
