package exercises

package object c11_operators {
  def sign(x: Int) = if (x > 0) 1 else if (x < 0) -1 else 0
  def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
  def lcm(x: Int, y: Int) = x * y / gcd(x, y)
}