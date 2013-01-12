package exercises.c07_packages

package object random {
  var previous: Int = 0
  
  val a = 1664525
  val b = 1013904223
  val n = 32
  
  def setSeed(seed: Int) { previous = seed }
  
  def nextInt(): Int = { previous = previous * a + b % (2*n); previous } 
}