package exercises.c10_traits

import scala.util.logging.Logged
import scala.util.logging.ConsoleLogger

trait MyLogger {
  def log(msg: String)
}

trait PrintLogger extends MyLogger {
  def log(msg: String) {
    println(msg)
  }
}

trait UpperCaseLogger extends MyLogger {
  abstract override def log(msg: String) {
    super.log(msg.toUpperCase())
  }
}

abstract class BankAccount(private var _balance: Double = 0.0) extends MyLogger {
  def balance = _balance
  private[this] def balance_=(newBalance: Double) { _balance = newBalance }
  
  def deposit(amount: Double): Double = {
    balance += amount
    balance
  }
  
  def withdraw(amount: Double): Double = {
    if (balance < amount) {
      log("Insufficient funds.")
    }
    else {
      balance -= amount
    }
    
    balance
  }
}

class BankApp extends App {
  val b = new BankAccount with PrintLogger with UpperCaseLogger
  val c = new BankAccount with MyLogger {
    def log(msg: String) {
      println(msg)
    }
  }
}