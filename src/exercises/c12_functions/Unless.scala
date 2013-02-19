// Exer10
package exercises.c12_functions

object UnlessApp extends App {
  def unless(condition: Boolean)(block: => Unit) {
    if (!condition)
      block
  }
  
  var b = false
  unless (b) {
    println("*")
  }
}