package exercises

import scala.annotation.tailrec
package object c14_match_case {
  
  // Exer02
  def swapPair(pair: (Int, Int)) = pair match {
    case (x, y) => (y, x)
  }

  // Exer03
  def swapFirst2(a: Array[Int]) = a match {
    case Array(x, y, z, r @ _*) => Array(y, x, z) ++ r
    case arr: Array[Int] => arr
  }
  
  // Exer05
  def leafSum(lst: List[Any]): Int = {
    if (lst.isEmpty) 0
    else (lst.head match {
      case h: Int => h
      case h: List[Any] => leafSum(h)
      case _ => 0
    }) + leafSum(lst.tail)
  }
  
  // Exer09
  def sumNonNone(lst: List[Option[Int]]) = lst.foldLeft(0)(_ + _.getOrElse(0))
}