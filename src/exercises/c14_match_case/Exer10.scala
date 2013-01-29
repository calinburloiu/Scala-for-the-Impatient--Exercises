// Exer10
package exercises.c14_match_case

// Solution 1: with PartialFunction-s
object Compose1 {
  def compose(f: Double => Option[Double], g: Double => Option[Double]) = {
    composePartial(unlift(f), unlift(g)).lift
  }
  
  def unlift(f: (Double) => Option[Double]): PartialFunction[Double, Double] =
    new PartialFunction[Double, Double] {
      def isDefinedAt(x: Double): Boolean = f(x).isDefined
      def apply(x: Double): Double = f(x).get
    }
  
  def composePartial(f: PartialFunction[Double, Double],
      g: PartialFunction[Double, Double]) = new PartialFunction[Double, Double] {
    def isDefinedAt(x: Double) = g.isDefinedAt(x) && f.isDefinedAt(g(x))
    def apply(x: Double) = f(g(x))
  }
  
}

// Solution 2: with Function1-s
object Compose2 {
  def compose(f: Double => Option[Double], g: Double => Option[Double]):
      (Double) => Option[Double] = new Function1[Double, Option[Double]] {
    def isDefinedAt(x: Double): Boolean = g(x).isDefined && f(g(x).get).isDefined
    def apply(x: Double): Option[Double] =
      if (isDefinedAt(x)) Some(f(g(x).get).get) else None
  }

}