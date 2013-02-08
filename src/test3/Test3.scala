package test3

trait B

case class X(x: Int = 1, y: Int = 2, z: Int = 3) extends B

case class Y(x: Int = 1987, y: Int = 1988) extends B

object Test3 extends App {
  val z: B = X(y = 10)
  
  z match {
    case X(x,10,z) => println("X %d %d %d".format(x, 10, z))
    case Y(x,y) => println("Y %d %d".format(x, y))
  }
}