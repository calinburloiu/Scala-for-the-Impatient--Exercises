package exercises.c08_inheritance

class BankAccount(initialBalance: Double) {
  protected var balance = initialBalance
  
  def deposit(amount: Double) = {balance += amount ; balance}
  def withdraw(amount: Double) = {balance -= amount ; balance}
}

class CheckingAccount(initialBalance: Double)
    extends BankAccount(initialBalance) {
  
  def applyCommision() {
    balance -= 1
  }
  
  override def deposit(amount: Double) = {
    applyCommision()
    super.deposit(amount)
  }
  
  override def withdraw(amount: Double) = {
    applyCommision()
    super.withdraw(amount)
  }
}

class SavingsAccount(initialBalance: Double)
    extends CheckingAccount(initialBalance) {
  
  val interestRate = 0.003
  protected var operationsLeft = 3
  
  override def applyCommision() {
    if (operationsLeft > 0) {
      operationsLeft -= 1
    }
    else {
      balance -= 1
    }
  }
  
  def earnMonthlyInterest() = {
    balance += interestRate * balance
    balance
  }
}