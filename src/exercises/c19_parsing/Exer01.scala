// Exer01
package exercises.c19_parsing
import scala.util.parsing.combinator.RegexParsers

class ExprParser extends RegexParsers {
  val number = "[0-9]+".r
  
  val mul = { (x: Double, y: Double) => x * y }
  val div = { (x: Double, y: Double) => x / y }
  val mod = { (x: Double, y: Double) => x % y }
  
  def expr: Parser[Double] = term ~ rep(
    ("+" | "-") ~ term ^^ {
      case "+" ~ t => t
      case "-" ~ t => -t
    }) ^^ { case t ~ r => t + r.sum }
  
  def term: Parser[Double] = 
    factor ~ rep(
      ("*" | "/" | "%") ~ factor ^^ {
        case "*" ~ f => (mul, f)
        case "/" ~ f => (div, f)
        case "%" ~ f => (mod, f)
      }) ^^ { case f ~ r => r.foldLeft(f) { (x, y) => y._1(x, y._2) } }
  
  def factor: Parser[Double] = number ^^ { _.toDouble } | "(" ~> expr <~ ")"
}  

object ExprParserApp extends App {
  val parser = new ExprParser
  var line: String = _
  
  def read() = {
    line = readLine
    !line.isEmpty
  }
  
  while (read()) {
    val result = parser.parseAll(parser.expr, line)
    if (result.successful) println("= " + result.get)
  }
}