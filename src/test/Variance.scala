package test

class Felina {
  def daCarnita() { println("hap!") }
}

class Pisica extends Felina {
  def mangaie() { println("trrr!") }
}

class Cotoroaba extends Pisica {
  def zatuie() { println("hhhhrrrr!") }
}

class Func extends Function1[Container[Pisica], Container[Pisica]] {
  def apply(input: Container[Pisica]) = { input.fa(); input }
}

class Container[+E](e: E) {
//  def fa() { e.mangaie() }
}

object Variance extends App {
  
  def foloseste(f: Function1[Pisica, Pisica], p: Pisica): Pisica = {
    f(p)
  }
  
  val f = new Function1[Felina, Cotoroaba] {
    def apply(input: Felina) = new Cotoroaba
  }
  foloseste(f, new Pisica)
  
  def makeFriends(p: Container[Pisica]) {}
  makeFriends(new Container(new Cotoroaba))
  
//  val g = new Func
//  g(new Container(new Cotoroaba))
}