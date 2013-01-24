package exercises.c12_functions
import exercises.c11_operators._

class FuncTest(var a: Int) {
  def f(x: Int, y: Int) = x + y
  
  def g(that: FuncTest) = new FuncTest(a * that.a)
  
  def p = {
    g _
  }
  
  override val toString = "" + a
}

object FuncTestApp extends App {
  val as = Array("Călin", "Andrei", "Burloiu")
  val al = Array(5, 6, 7)
  println(areStringLengthCorresponding2(as, al))
  
  val m = new FuncTest(3)
  val n = new FuncTest(4)
  val o = new FuncTest(5)
  
  val gm = m.g _
  val gn = n.g _
  
  println(gm(o))
  m.a = 30
  println(gm(o))
  
  println(gn(o))
  n.a = 40
  println(gn(o))
}