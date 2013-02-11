// Exer04
// Test with 'Exer04Java.java'.
package exercises.c15_annotations
import scala.annotation.varargs

class JavaFriend1 {
  @varargs
  def sum(terms: Int*): Int =
    if (terms.isEmpty) 0 else terms.head + sum(terms.tail: _*)
}

object Exer04 extends App {
  println( (new JavaFriend1).sum(1, 3, 5, 7) )
}