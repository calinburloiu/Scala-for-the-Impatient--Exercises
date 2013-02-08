package exercises.c18_advanced_types

class C {
  println("Init C")
  
  def f {
    println("C.f")
  }
}

class D extends C {
  println("Init D")
}

trait X1 {
  this: C =>
    println("Init X1")
    
  override def f {
    println("X1.f")
  }
}

trait X2 extends C {
  println("Init X2")
  
  override def f {
    super.f
    println("X2.f")
  }
}

trait X31 extends C with X1 {
  println("Init X31")
  
  override def f {
    super.f
    println("X31.f")
  }
}

trait X32 extends X2 {
  println("Init X32")
  
  override def f {
    super.f
    println("X32.f")
  }
}

object Exer10 extends App {
  (new D with X31).f
  println
  (new D with X32).f
  println
}