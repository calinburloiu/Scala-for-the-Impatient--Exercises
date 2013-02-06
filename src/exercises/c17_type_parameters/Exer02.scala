// Exer02
package exercises.c17_type_parameters

// Mutable Swapping Pair
class MSPair[T](var left: T, var right: T) {
  def swap() {
    val tmp = left
    left = right
    right = tmp
  }
  
  override def toString = "" + (left, right)
}
