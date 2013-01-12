package exercises.c06_objects

object Origin extends java.awt.Point {
  x = 0
  y = 0
}

object Point {
  def apply(x: Int, y: Int) = new Point(x, y)
}

class Point(val x: Int, val y: Int) {
  override def toString() = "(%d, %d)".format(x, y)
}
