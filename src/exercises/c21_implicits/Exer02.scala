// Exer02
package exercises.c21_implicits

class MyRichVal[@specialized T](val x: T) {
  def +%(percent: Int): T =
      math.round(this.x.asInstanceOf[Double] * (1 + percent / 100.0)).asInstanceOf[T]
}

object Exer02 extends App {
  println(true +% 5)
}
