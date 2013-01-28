package exercises
import collection.immutable._
import collection.mutable
import scala.annotation.tailrec

package object c13_collections {
  def fibo(n: Int) = n match {
    case 0 => Vector(0)
    case 1 => Vector(0, 1)
    case _ =>
        (Vector(0, 1) /: (2 to n)) { (v, i) => v :+ (v(i-1) + v(i-2)) }
  }

  def fiboStream: Stream[Int] = 0 #:: 1 #:: {
    def f(a: Int, b: Int): Stream[Int] = (a + b) #:: f(b, a + b)
    f(0, 1)
  }
  
  def charIndex(str: String, index: Int): SortedMap[Char, SortedSet[Int]] = {
    if (str.isEmpty) {
      SortedMap()
    }
    else {
      val nextMap = charIndex(str.tail, index + 1)
      nextMap + (str(0)
          -> (nextMap.getOrElse(str(0), SortedSet[Int]()) ++ SortedSet(index)))
    }
  }
  
  def charIndexMutable(str: String) = {
    val map = new mutable.LinkedHashMap[Char, mutable.LinkedHashSet[Int]]
    var elem: mutable.LinkedHashSet[Int] = null
    var i = 0
    
    while (i < str.length) {
      elem = map.getOrElseUpdate(str(i), mutable.LinkedHashSet())
      elem += i
      
      i += 1
    }
    
    map
  }
  
  def rmZeros(list: mutable.LinkedList[Int]) = {
    var retList: mutable.LinkedList[Int] = null
    if (list.elem == 0)
      retList = list.next
    else
      retList = list
    var cur = retList
    
    while (cur.next != Nil) {
      if (cur.next.elem == 0)
        cur.next = cur.next.next
      
      cur = cur.next
    }
    
    retList
  }
  
  def exer4(a: Seq[String], m: Map[String, Int]) = a.flatMap(m.get(_))
  
  def myMkString(coll: Iterable[Any], sep: String) = coll.reduceLeft(_ + sep + _)
  
  def reverse(lst: List[Int]) = (lst :\ List[Int]())((x, y) => y ++ List(x))
  def reverse2(lst: List[Int]) = (List[Int]() /: lst)((x, y) => y +: x)
  
  def calcPrices(prices: Seq[Float], quantities: Seq[Int]) =
    (prices zip quantities) map { ((p: Float, q: Int) => p * q).tupled }
  
  def matrixize(a: Array[Int], n: Int): Array[Array[Int]] = {
    val il = a.length / n
    val out = new Array[Array[Int]](il)
    var i = 0
    
    val it = a.grouped(n)
    while (it.hasNext && i < il) {
      out(i) = it.next
      i += 1
    }
    
    out
  }
  
}
