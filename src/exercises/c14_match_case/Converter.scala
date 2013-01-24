package exercises.c14_match_case

object Converter extends App {
  val rates = Map("dollar" -> 3.26, "euro" -> 4.36)
  val regex = "([0-9]+) ([a-zA-Z]+)".r
  
  def convert(expr: String) = expr match {
    case regex(amount, "SGD") => "cannot lah"
    case regex(amount, currency) if (rates.getOrElse(currency, null) != null) => amount.toInt * rates(currency) + " lei"
    case regex(amount, _) => "?"
    case _ => "error"
  }
  
  println(convert("2 SGD"))
  println(convert("2 euro"))
  println(convert("2 dollar"))
  println(convert("2 leva"))
  println(convert("srr"))
}
