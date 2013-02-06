// Exer01
// Exer03
package exercises.c17_type_parameters

// Immutable Swapping Pair
class ISPair[T, S](val left: T, val right: S) {
  def swap = new ISPair(right, left)
  def swap[T, S](pair: ISPair[T, S]) = new ISPair(pair.right, pair.left)
  
  override val toString = "" + (left, right)
}
