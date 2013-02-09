// Exer05
package exercises.c21_implicits

object Fraction {
  def apply(numerator: Int, denominator: Int) = new Fraction(numerator, denominator)
}

class Fraction(val numerator: Int, val denominator: Int) {
  override val toString = numerator + "/" + denominator
}

class RichFraction(n: Int, d: Int) extends Fraction(n, d) with Ordered[Fraction] {
  def compare(that: Fraction) =
      (numerator.asInstanceOf[Double] / denominator * 1000).asInstanceOf[Int] -
          (that.numerator.asInstanceOf[Double] / that.denominator * 1000).asInstanceOf[Int]
}

object Exer05 extends App {
  println( smaller(Fraction(1, 7), Fraction(2, 9)) )
}