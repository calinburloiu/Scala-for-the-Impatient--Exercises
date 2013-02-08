package exercises

package object c18_advanced_types {
  // Exer06
  def findIndex(array: Array[Int], n: Int): Either[Int, Int] = {
    // Divide and Conquer
    def findIndexDC(array: Array[Int], start: Int, end: Int, n: Int):
        Either[Int, Int] = {
      if (end - start == 0) {
        if (array(start) == n) Right(array(start)) else Left(array(start))
      }
      else {
        val l = findIndexDC(array, start, start + (end-start) / 2, n)
        val r = findIndexDC(array, start + (end-start) / 2 + 1, end, n)
//        println("l: " + l)
//        println("r: " + r)
        
        if (l.isInstanceOf[Left[_, _]] && r.isInstanceOf[Left[_, _]]) {
          val dl = math.abs(l.left.get - n)
          val dr = math.abs(r.left.get - n)
          if (dl < dr) l else if (dl == dr) l else r
        }
        else if (l.isInstanceOf[Left[_, _]]) {
          r
        }
        else if (r.isInstanceOf[Left[_, _]]) {
          l
        }
        else throw new Error("Cannot, lah!")
      }
    }
    
    findIndexDC(array, 0, array.size - 1, n)
  }
  
  // Exer07
  def process(closeable: { def close(): Unit }) {
    def doSomething(obj: Any) {
      println("Calling toString on the object: " + obj)
    }
    
    doSomething(closeable)
    closeable.close()
  }
  
  // Exer08
  def printValues(f: { def apply(n: Int): Int }, from: Int, to: Int) {
    (from to to).foreach((n: Int) => println(f(n)))
  }
}