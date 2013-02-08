package exercises.c18_advanced_types

abstract class Dim[T](val value: Double, val name: String) {
  protected def create(v: Double): T
  def +(other: Dim[T]) = create(value + other.value)
  override def toString() = value + " " + name
}

class Seconds(v: Double) extends Dim[Seconds](v, "s") {
  this: Seconds =>
  override val value = v
  override def create(v: Double) = new Seconds(v)
}

class Meters(v: Double) extends Dim[Seconds](v, "m") {
  override def create(v: Double) = new Seconds(v)
}

object Exer09 extends App {

}