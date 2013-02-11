package test
import scala.util.parsing.combinator.RegexParsers

class Expr
case class Number(value: Int) extends Expr
case class Operator(op: String, left: Expr, right: Expr) extends Expr

class ExprParser2 extends RegexParsers {
  val wholeNumber = "[0-9]+".r
  
  def expr: Parser[Expr] = term ~ opt(("+" | "-") ~ expr) ^^ {
    case t ~ None => t
    case t ~ Some("+" ~ e) => Operator("+", t, e)
    case t ~ Some("-" ~ e) => Operator("-", t, e)
  }
  
//  val interpretTerm: PartialFunction[Parser[Expr], Expr] = {
//    case a ~ List() => a
//    case a ~ List(b) => Operator("*", a, b)
//  }
  
  def term: Parser[Expr] = factor ~ rep("*" ~> factor) ^^ {
    case a ~ List() => a
    case a ~ List(b) => Operator("*", a, b)
//    case a ~ List(bh, bt @ _*) => Operator("*", a, Operator("*", bh, ))
  }
  
  def factor: Parser[Expr] = wholeNumber ^^ { n => Number(n.toInt) } | "(" ~> expr <~ ")"
}

object ExprParser2App extends App {
  val parser = new ExprParser2
  val result = parser.parseAll(parser.expr, "3-4*5")
  if (result.successful) println(result.get)
}