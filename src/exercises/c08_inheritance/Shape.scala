package exercises.c08_inheritance

abstract class Shape {
  def centerPoint: Point
}

/**
 * A rectangle which has the corner points a, b, c, d.
 */
class Rectangle(val a: Point, val c: Point) extends Shape {
  def centerPoint = new LabeledPoint("rectangle center", (a.x + c.x) / 2,
      (a.y + c.y) / 2)
}

/**
 * A circle with two points a and b on it, placed on the diameter.
 */
class Circle(val a: Point, val b: Point) extends Shape {
  def centerPoint = new LabeledPoint("circle center", (a.x + b.x) / 2,
      (a.y + b.y) / 2)
}

class Square(corner: Point, width: Int)
  extends java.awt.Rectangle(corner.x.asInstanceOf[Int],
      corner.y.asInstanceOf[Int], width, 10) {
  
  def this() {
    this(new Point(0, 0), 0)
  }
  
  def this(width: Int) {
    this(new Point(0, 0), width)
  }
}