package exercises.c08_inheritance

class Point(val x: Double, val y: Double)

class LabeledPoint(
    val label: String, 
    override val x: Double,
    override val y: Double)
  extends Point(x, y) {
  
  override def toString = "%s (%.2f, %.2f)".format(label, x, y) 
}