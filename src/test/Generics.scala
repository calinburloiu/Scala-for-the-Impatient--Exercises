package test

class Person(val name: String) /*extends Comparable[Person]*/ {
  override val toString = name
//  override def compareTo(that: Person) = this.name.compareTo(that.name)
}

class Man(nameC: String) extends Person(nameC)
class Woman(nameC: String) extends Person(nameC)

class Pair1[T <: Comparable[T]](val x: T, val y: T) {
  override val toString = "(" + x + ", " + y + ")"
  def smaller = if (x.compareTo(y) < 0) x else y
}

class Pair2[T](val x: T, val y: T) {
  override val toString = "(" + x + ", " + y + ")"
  def replaceX[R >: T](newX: R) = new Pair2(newX, y)
}

class Pork extends Man("pork")
class Bitch extends Woman("bitch")

object Generics {
  val a = new Person("anonim")
  val b = new Person("anonimă")
  val ion = new Man("ion")
  val vasile = new Man("vasile")
  val maria = new Woman("maria")
  val gay = new Pair2(ion, vasile)
  
  gay.replaceX(a)
  gay.replaceX(maria)
  gay.replaceX(vasile)
  gay.replaceX(new Pork)
  gay.replaceX("cici")
}
