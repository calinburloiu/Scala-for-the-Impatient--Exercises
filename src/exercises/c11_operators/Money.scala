package exercises.c11_operators
import math.{abs, ceil}

object Money {
  def apply(d: Int, c: Int) = new Money(d, c)
}

class Money(val d: Int, val c: Int) {
  val total: Int = d * 100 + c 
  val dollars: Int = total / 100
  val cents: Int = total % 100 
  
  override val toString = dollars + "$ " + cents + "¢"
  
  def +(that: Money) = new Money(this.dollars + that.dollars, this.cents + that.cents)
  def -(that: Money) = new Money(this.dollars - that.dollars, this.cents - that.cents)
  
  def <(that: Money) = this.total < that.total
  def <=(that: Money) = this.total <= that.total
  def >(that: Money) = this.total > that.total
  def >=(that: Money) = this.total >= that.total
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Money])
      this.total == that.asInstanceOf[Money].total
    else
      false
  }
}

object MoneyApp extends App {
  println(new Money(-1, 270))
}