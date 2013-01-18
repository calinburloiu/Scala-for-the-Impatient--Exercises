package exercises.c11_operators

object MyArray {
  def apply(values: Int*) = new MyArray(values: _*)
  
  def unapplySeq(a: MyArray): Option[Seq[Int]] = if (a.a.isEmpty) None else Some(a.a)
  
//  def unapply(a: MyArray) = Some(a(0))
}

class MyArray(_a: Int*) {
  val a = _a.toArray
  
  override def toString = a.foldLeft("")(_ + " " + _.toString)
  
  def apply(index: Int) = a(index)
  def apply(indexes: Int*) = indexes.map(a(_))
  
  def update(index: Int, value: Int) {
    a(index) = value
  }
  def update(indexes: Seq[Int], value: Int) {
    indexes.map({this(_) = value})
  }
  
  def unapply(s: String) = {
    val tokens = s.split("""[\s]+""")
    Some(a.map(tokens(_)))
  }
}

object OpTest extends App {
  val a = MyArray(0, 1, 2)
  val b = MyArray(1, 2, 3)
  val c = MyArray(11, 2, 3)
  var x = c
  
  x match {
    case MyArray(0) => println("miden")
    case MyArray(1) => println("ena")
    case _ => println("_")
  }
}