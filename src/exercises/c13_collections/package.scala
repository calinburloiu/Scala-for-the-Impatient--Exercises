package exercises

package object c13_collections {
  def fibo(n: Int) = n match {
    case 0 => Vector(0)
    case 1 => Vector(0, 1)
    case _ =>
        (Vector(0, 1) /: (2 to n)) { (v, i) => v :+ (v(i-1) + v(i-2)) }
  }

  def fiboStream: Stream[Int] = 0 #:: 1 #:: {
    def f(a: Int, b: Int): Stream[Int] = (a + b) #:: f(b, a + b)
    f(0, 1)
  }
}
