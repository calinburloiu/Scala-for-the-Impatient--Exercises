package exercises

class PackageTest {
  private val t = new c07_packages.Test
  println(t.x)
  
  def f {
    val s = new Sub
    println(s.y)
  }
  
  class Sub {
    private[PackageTest] val y = 0
    
    def g {
      println(t)  
    }
  }
}