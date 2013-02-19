// Exer07
package exercises.c11_operators

class BitSequence {
  var b: Long = 0L
  
  override def toString = b.toBinaryString
  
  def apply(i: Int): Int = (((1L << i) & b) >> i).asInstanceOf[Int]
  def update(i: Int, value: Int) {
    if (value == 1)
      b |= (1L << i)
    else if (value == 0)
      b &= ~(1L << i)
  }
}