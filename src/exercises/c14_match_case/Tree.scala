package exercises.c14_match_case

// Exer06: use case class DiNode
// Exer07: use case class PolyNode
object Tree {
  def leafSum(tree: Tree): Int = tree match {
    case leaf: Leaf => leaf.value
    case node: DiNode => leafSum(node.left) + leafSum(node.right)
    case node: PolyNode => node.children.foldLeft(0)(_ + leafSum(_))
    case _ => 0
  } 
}

sealed abstract class Tree
case class Leaf(value: Int) extends Tree
case class DiNode(left: Tree, right: Tree) extends Tree
case class PolyNode(children: Tree*) extends Tree
