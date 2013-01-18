package exercises.c11_operators
import math.abs

object Fraction {
  def apply(n: Int, d: Int) = new Fraction(n, d)
  def unapply(f: Fraction) = Some((f.num, f.den))
}

class Fraction(n: Int, d: Int) {
  val num = if (d == 0) 1 else n * sign(d) / abs(gcd(n, d))
  val den = if (d == 0) 0 else d * sign(d) / abs(gcd(n, d))
  
  def unary_- = new Fraction(-this.num, this.den)
  
  def unary_~ = new Fraction(this.den, this.num)
  
  def +(that: Fraction) = {
    val m = lcm(this.den, that.den)
    new Fraction(m / this.den * this.num + m / that.den * that.num, m)
  }
  
  def -(that: Fraction) = this + (-that)
  
  def *(that: Fraction) = new Fraction(this.num * that.num, this.den * that.den)
  
  def /(that: Fraction) = this * ~that
  
  override val toString = num + "/" + den
}

object FractionApp extends App {
  println(new Fraction(15, 10))
  println(new Fraction(-15, -10))
}