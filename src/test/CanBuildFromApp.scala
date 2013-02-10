package test
import scala.collection.generic.CanBuildFrom
import scala.collection.mutable._

object FibonacciSeq {
  implicit def myCanBuildFrom =
      new CanBuildFrom[Iterable[Long], Long, ArrayBuffer[Long]] {
    def apply() = new ArrayBuffer[Long]
    def apply(from: Iterable[Long]) = new ArrayBuffer[Long]
  }
}

class FibonacciSeq(override val size: Int) extends Iterable[Long] {
  val stream = createFibonacciStream.take(size).force
  
  def createFibonacciStream: Stream[Long] = 0 #:: 1 #:: {
    def f(a: Long, b: Long): Stream[Long] = (a + b) #:: f(b, a + b)
    f(0, 1)
  }
  
  def iterator = new Iterator[Long] {
    val it = stream.iterator
    
    def hasNext = it.hasNext
    def next = it.next
  }
}

object CanBuildFromApp extends App {
  val fib = new FibonacciSeq(50)
  
  for (i <- fib.sliding(2)) {
    val it = i.iterator
    val x = it.next
    val y = it.next
    if (x != 0) printf("%f = %d / %d\n", y.asInstanceOf[Double] / x, y, x)
  }
}