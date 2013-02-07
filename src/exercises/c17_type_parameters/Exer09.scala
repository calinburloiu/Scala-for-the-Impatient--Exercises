// Exer09
package exercises.c17_type_parameters

class NastyPair[+T](val first: T, val second: T) {
  def replaceFirst[R >: T](newFirst: R) = new NastyPair(newFirst, second)
  
  override val toString = "" + (first, second)
}

class NastyDoublePair(firstC: Double, secondC: Double)
    extends NastyPair[Double](firstC, secondC) {
  override def replaceFirst[R >: Double](newFirst: R) = {
    newFirst match {
      case x: Double =>
          new NastyDoublePair(math.sqrt(x.asInstanceOf[Double]), second)
      case _ => new NastyDoublePair(Double.NaN, second)
    }
  }
}

object Exer09App extends App {
  val p: NastyPair[Any] = new NastyDoublePair(4.0, 5.0)
  p.replaceFirst("Hello")
}