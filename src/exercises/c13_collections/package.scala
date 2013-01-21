package exercises

package object c13_collections {
  def fibo(n: Int) = n match {
    case 0 => List(0)
    case 1 => List(0, 1)
    case _ =>
        (Vector(0, 1) /: (2 to n)) { (v, i) => v :+ (v(i-1) + v(i-2)) }
  }
}
