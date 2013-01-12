
import scala.reflect.BeanProperty

class Person(name: String = "John Doe", private var _age: Int = 0) {
  if (age < 0) age = 0

  def this(x: Int) { this("a b", x) }
  def this(f: Double) { this(f.asInstanceOf[Int]) }
  
  private var z_ = 0
  def z = z_
  
  val firstName = name.split(" ")(0)
  val lastName = name.split(" ")(1)
  
  def age = _age
  def age_=(age: Int) {
    if (age > this.age) _age = age
  }
}

class Employee(name: String = "John Doe", private var _age: Int = 0,
    salary: Double = 0.0) extends Person(name, _age) {
  override def z = 3
}

class Cat

object Țiți extends Cat

object PG extends App {
  val coto = new Cat
  val vidanjor = new Employee
  val gigel = new Person("Gigel Popescu", 42)
  
  val x = vidanjor.asInstanceOf[Person]
  if (vidanjor.getClass == classOf[Employee]) println("Uraa!")
  
  var y = Țiți.asInstanceOf[Object]
  
  y match {
    case Țiți => println("Țiți pisica")
    case o: Employee => println("angajatul " + o)
    case o: Cat => println("cotoroaba " + o)
    case o: Person => println("persoana " + o)
    case null => println("nimic coaie")
    case _ => println("altceva")
  }
}
