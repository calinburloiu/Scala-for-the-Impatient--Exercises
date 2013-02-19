// Exer01
package exercises.c10_traits
import java.awt.geom.RectangularShape

trait RectangleLike {
  this: RectangularShape =>
  
  def translate(dx: Double, dy: Double) {
    setFrame(getX + dx, getY + dy, getWidth, getHeight)
  }
  
  def grow(h: Double, v: Double) {
    setFrame(getX, getY, getWidth + h, getHeight + v)
  }
}

object RectangleLikeTest extends App {
  val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
  egg.translate(.1, .2)
  egg.grow(.3, .4)
  println("%f %f %f %f".format(egg.getX, egg.getY, egg.getWidth, egg.getHeight))
}