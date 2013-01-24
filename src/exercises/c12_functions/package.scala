package exercises

package object c12_functions {
  def values(fun: (Int) => Int, low: Int, high: Int) = {
    for (i <- low to high) yield Pair(i, fun(i))
  }
  
  def max(a: Seq[Int]) = a.reduceLeft((x, y) => if (x >= y) x else y)
  
  def fact(n: Int) = if (n < 1) 1 else (2 to n).reduceLeft(_ * _)

  def largest(fun: (Int) => Int, inputs: Seq[Int]) = max(inputs.map(fun(_)))
  
  def largestAt(fun: (Int) => Int, inputs: Seq[Int]) =
      inputs.map(x => Pair(x, fun(x))).
      reduceLeft((x, y) => if (x._2 >= y._2) x else y)._1
  
//  def adjustToPair(fun: (Int, Int) => Int)(pair: (Int, Int)) =
//    fun(pair._1, pair._2)
    
  def adjustToPair[A, B, C](fun: (A, B) => C)(pair: (A, B)) =
    fun(pair._1, pair._2)
  
  def adjustToPairTest {
    val pairs = (1 to 10) zip (11 to 20)
    println(pairs.map(adjustToPair(_ + _)))
  }
  
  def areStringLengthCorresponding(strings: Seq[String], lengths: Seq[Int]) =
      strings.corresponds(lengths)(_.length == _)
  
  def corresponds2[A, B](a: Seq[A], b: Seq[B], fun: (A, B) => Boolean): Boolean =
    (a zip b).map(adjustToPair(fun(_, _))).reduceLeft(_ && _ == true)
    
  def areStringLengthCorresponding2(strings: Seq[String], lengths: Seq[Int]) =
      corresponds2[String, Int](strings, lengths, { _.length == _ })
}