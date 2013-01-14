package exercises.c08_inheritance

class Polygon(var width: Double, var height: Double)

class MyRectangle(initWidth: Double, initHeight: Double)
    extends Polygon(initWidth, initHeight) {
  def area = width * height;
}

class MyTriangle(initWidth: Double, initHeight: Double)
    extends Polygon(initWidth, initHeight) {
  def area = width * height / 2
}
