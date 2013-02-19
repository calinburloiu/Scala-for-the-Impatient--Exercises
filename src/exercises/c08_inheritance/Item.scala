// Exer04
package exercises.c08_inheritance
import scala.collection.mutable.ArrayBuffer

abstract class Item {
  def price: Double
  def description: String
}

class SimpleItem(
    override val price: Double,
    override val description: String)
  extends Item

class Bundle extends Item {
  val items = new ArrayBuffer[Item](10)
  
  override def price = items.foldLeft(0.0)(_ + _.price)
  override def description = {
    if (items.isEmpty) "empty bundle"
    else items.foldLeft("bundle of ")(_ + _.description + ", ")
  }
  
  def addItem(item: Item) { items += item }
}
