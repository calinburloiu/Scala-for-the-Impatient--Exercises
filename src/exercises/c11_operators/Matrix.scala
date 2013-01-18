package exercises.c11_operators

object Matrix {
  def apply(a: Double, b: Double, c: Double, d: Double) = new Matrix(a, b, c, d)
}

class Matrix(a: Double, b: Double, c: Double, d: Double) {
  private val m = Array(Array(a, b), Array(c, d))
  
  override val toString = "%.2f\t%.2f\n%.2f\t%.2f".format(a, b, c, d)
  
  def apply(i: Int, j: Int) = m(i)(j)
  
  def +(that: Matrix) = new Matrix(this(0,0) + that(0,0), this(0,1) + that(0,1),
      this(1,0) + that(1,0), this(1,1) + that(1,1))
  
  def *(that: Matrix) = new Matrix(this(0,0) * that(0,0) + this(0,1) * that(1,0),
      this(0,0) * that(0,1) + this(0,1) * that(1,1),
      this(1,0) * that(0,0) + this(1,1) * that(1,0),
      this(1,0) * that(0,1) + this(1,1) * that(1,1))
  
  def *(n: Int) = new Matrix(n*a, n*b, n*c, n*d)
}