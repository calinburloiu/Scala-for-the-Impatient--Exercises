// Exer08
package exercises.c14_match_case

object OpTree {
  
  def compute(tree: OpTree): Double = tree match {
    case v: Num => v.value
    case t: Plus =>
      t.children.foldLeft(0.0)(_ + compute(_))
    case x: Minus =>
     -compute(x.child)
    case f: Mul =>
      f.children.foldLeft(1.0)(_ * compute(_))
    case d: Div =>
      compute(d.left) / compute(d.right)
  }
}

sealed abstract class OpTree
case class Num(value: Double) extends OpTree
case class Plus(children: OpTree*) extends OpTree
case class Minus(child: OpTree) extends OpTree
case class Mul(children: OpTree*) extends OpTree
case class Div(left: OpTree, right: OpTree) extends OpTree
