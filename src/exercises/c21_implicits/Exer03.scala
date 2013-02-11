// Exer03
package exercises.c21_implicits
import scala.annotation.tailrec

class Factorial(val n: Int) {
  def fact(n: Int): Int = {
    @tailrec
    def tailrecFact(n: Int, acc: Int): Int =
        if (n == 1) acc else if (n == 0) 1 else tailrecFact(n - 1, acc * n)
    tailrecFact(n, 1)
  }
  
  def ! = fact(this.n)  // Actually it's possible :-D
//  def ¡ = fact(this.n)  // But this is an error :-o
}

object Exer03 extends App {
  println( 5! )
}