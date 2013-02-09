// Exer03
package exercises.c21_implicits

class Factorial(val n: Int) {
  def fact(n: Int): Int = if (n == 1) 1 else if (n == 0) 1 else fact(n - 1) * n
  
  def ! = fact(this.n)  // Actually it's possible :-D
//  def ¡ = fact(this.n)  // But this is an error :-o
}

object Exer03 extends App {
  println( 5! )
}