// Exer10
package exercises.c17_type_parameters

class Exer10Pair[S, T](var left: S, var right: T) {
  def swap()(implicit ev: S =:= T, ev2: T =:= S) {
    val tmp = left
    left = right
    right = tmp
  }
  
  override def toString = "" + (left, right)
}
