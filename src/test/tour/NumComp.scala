trait Ord {
  def <(that: Any): Boolean
  def <=(that: Any): Boolean = (this < that) || (this == that)
  def >(that: Any): Boolean = !(this <= that)
  def >=(that: Any): Boolean = !(this < that)
}

class Num(num: Int) extends Ord {
  def n: Int = num

  override def toString() = n.toString()

  override def equals(that: Any): Boolean =
    that.isInstanceOf[Num] && {
      val o = that.asInstanceOf[Num]
      o.n == n
    }

  def <(that: Any): Boolean = {
    if (!that.isInstanceOf[Num])
      sys.error("cannot lah!")

    val o = that.asInstanceOf[Num]
    n < o.n
  }
}

// vim: set ts=4 sw=4 et:
