package exercises.c10_traits

trait Logger {
  def log(msg: String)
}

trait CrytoLogger extends Logger {
  var key: Int = 13
  
  abstract override def log(msg: String) { super.log(encrypt(msg)) }
  
  def encrypt(str: String) = str.map((c: Char) => (c + key).asInstanceOf[Char])
}

trait ConsoleLogger extends Logger {
  def log(msg: String) { println(msg) }
}

object TraitsTest extends App with ConsoleLogger with CrytoLogger {
  log("Ana are mere.")
}