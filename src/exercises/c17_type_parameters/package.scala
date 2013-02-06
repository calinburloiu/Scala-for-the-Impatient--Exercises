package exercises

package object c17_type_parameters {
  // Exer06
  def mid[T](coll: Iterable[T]) = {
    var i = 0
    var it = coll.iterator
    val midPos = if (it.hasNext) coll.iterator.size / 2 else 0
    while (it.hasNext && i < midPos) {
      i += 1
      println("" + it.next)
    }
    
    if (it.hasNext)
      it.next
    else
      throw new Error
  }
  
}