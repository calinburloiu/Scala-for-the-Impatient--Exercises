package exercises.c14_match_case

sealed abstract class Item {
  def price: Float
}

case class Product(name: String, price: Float) extends Item {
  override def toString = "(%s, %f)".format(name, price)
}

case class Multiple(count: Int, item: Item) extends Item {
  def price = count * item.price
  override def toString = count + "x" + item
}

case class Bundle(items: Item*) extends Item {
  def price = items.foldLeft(0.0f)(_ + _.price)
  override def toString = items.foldLeft("")(_ + ", " + _)
}

object Products extends App {

}