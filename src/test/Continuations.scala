package test
import scala.util.continuations._

object Continuations extends App {
  var cont: Int => String = null

  val r = reset {
    println("Before shift")
    
    val s = "EXPRESSION " + shift { (k: Int => String) =>
      cont = k
      println("Inside shift")
      "END OF SHIFT"
    }
    
    "END OF RESET: " + s
    //println("After shift ")
  }
  println("After reset " + r)

  println(cont(2))
}
