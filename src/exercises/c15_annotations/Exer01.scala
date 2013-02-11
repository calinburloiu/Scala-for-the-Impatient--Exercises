// Exer01
package exercises.c15_annotations
import org.junit.Before
import org.junit.Test
import org.junit.Assert._
import org.junit.runner.JUnitCore

case class Money(amount: Double, currency: String) {
  def checkCurrency(that: Money) {
    if (currency != that.currency)
      throw new MoneyException
  }
  
  def +(that: Money) = {
    checkCurrency(that)
    Money(amount + that.amount, currency)
  }
  
  def timeout = {
    Thread.sleep(5000)
    true
  }
}

class MoneyException extends Exception

class MoneyTest {
  private var chf1: Money = _
  private var chf2: Money = _
  private var usd1: Money = _
  
  @Before
  def setUp() {
    chf1 = Money(12, "CHF")
    chf2 = Money(14, "CHF")
    usd1 = Money(28, "USD")
  }
  
  @Test
  def simpleAdd {
    assertTrue(chf1 + chf2 == Money(26, "CHF"))
  }
  
  @Test(expected = classOf[MoneyException])
  def wrongCurrency {
    chf1 + usd1 == Money(30, "CHF")
  }
  
  @Test(timeout = 6000)
  def timeout {
    assertFalse(chf1.timeout)
  }
}

object JUnitTest extends App {
  JUnitCore.runClasses(classOf[MoneyTest])
}