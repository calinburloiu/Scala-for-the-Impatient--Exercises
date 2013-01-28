package exercises

package object c14_match_case {
  def swapPair(pair: (Int, Int)) = pair match {
    case (x, y) => (y, x)
  }

  def swapFirst2(a: Array[Int]) = a match {
    case Array(x, y, z, r @ _*) => Array(y, x, z) ++ r
    case arr: Array[Int] => arr
  }
  
  def leafSum(lst: List[Any]): Int = {
    if (lst.isEmpty) 0
    else (lst.head match {
      case h: Int => h
      case h: List[Any] => leafSum(h)
      case _ => 0
    }) + leafSum(lst.tail)
  }

}