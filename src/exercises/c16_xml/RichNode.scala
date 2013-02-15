package exercises.c16_xml
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