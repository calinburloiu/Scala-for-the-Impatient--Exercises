package test

class PairA[T : Ordering](val a: T, val b: T) {
  def smaller(implicit ord: Ordering[T]) = if (ord.compare(a, b) < 0) a else b
}

class PairB[T <: Ordering[T]](val a: T, val b: T) {
  def smaller(implicit ord: Ordering[T]) = if (ord.compare(a, b) < 0) a else b
}

class PairC[T <% Ordered[T]](val a: T, val b: T) {
  def smaller = if (a < b) a else b
}

class C(val n: Int) extends Ordered[C] {
  def compare(that: C) = this.n - that.n 
}

class D(val n: Int)

object Implicits extends App {
  implicit def dOrdering = new Ordering[D] {
    def compare(a: D, b: D) = a.n - b.n
  }
  
  new PairA[D](new D(2), new D(3)).smaller
//  new PairB[Int](2,3).smaller
  new PairC[C](new C(2), new C(3)).smaller
  
  def testEquality[A, B](a: A, b: B)(implicit ev: A =:= B): Boolean = a == b
}