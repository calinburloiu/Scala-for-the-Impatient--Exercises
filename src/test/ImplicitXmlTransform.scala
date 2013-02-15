package test
import xml._
import scala.xml.transform.RewriteRule
import scala.xml.transform.RuleTransformer

object RichNode {
  def apply(node: Node) = new RichNode(node)
  implicit def node2RichNode(node: Node): RichNode = RichNode(node)
  implicit def makeRewriteRule(f: Node => Node): RewriteRule = new RewriteRule {
    override def transform(n: Node): Node = f(n)
  }
}

class RichNode(val node: Node) {
  import RichNode.makeRewriteRule
  
  def transform(f: Node => Node): Seq[Node] =
    new RuleTransformer(f).transform(node)
}

object ImplicitXmlTransform extends App {
  import RichNode.node2RichNode
  
  val list: Node = <ul><li>Bob</li><li>Alice</li></ul>
  val g = (n: Node) => n match {
    case u @ <ul>{_*}</ul> => u.asInstanceOf[Elem].copy(label = "ol")
    case _ => n
  }
  val newList = list.transform(g)
  
  println(newList(0))
}