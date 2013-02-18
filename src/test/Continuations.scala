package test
import scala.util.continuations._

object Continuations extends App {
  var cont: Unit => Unit = null

  reset {
    println("Before shift")
    shift { (k: Unit => Unit) =>
      cont = k
      println("Inside shift")
    }
  }
  println("After reset")
}
