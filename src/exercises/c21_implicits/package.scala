package exercises

package object c21_implicits {
  implicit def val2MyRichVal[@specialized T](x: T) = new MyRichVal(x)
  implicit def int2Factorial(n: Int) = new Factorial(n)
  
  implicit def fraction2RichFraction(x: Fraction) =
      new RichFraction(x.numerator, x.denominator)
  def smaller[T](a: T, b: T)(implicit ordered: T => Ordered[T]) =
      if (a < b) a else b
  
  def Obtain(what: TypeToObtain) = new ReadDsl(what)
}