package exercises

package object c15_annotations {
  // Exer08
  def allDifferent[@specialized T](a: T, b: T, c: T) = a != b && b != c
  
  def factorial(n: Int): Int = {
    assert(n >= 0, "whole number parameter")
    if (n < 0) throw new Error("The argument needs to be a whole number.")
    if (n == 1) 1 else if (n == 0) 1 else factorial(n - 1) * n
  }
}