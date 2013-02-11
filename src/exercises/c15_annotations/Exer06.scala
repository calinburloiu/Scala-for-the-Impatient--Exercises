// Exer06
package exercises.c15_annotations

object Volatile {
  @volatile var bool: Boolean = false
}

object setterTask extends Runnable {
  override def run() {
    Thread.sleep(5000)
    Volatile.bool = true
  }
}

object checkerTask extends Runnable {
  override def run() {
    while (!Volatile.bool) {
      Thread.sleep(100)
    }
    println("Field's value is now true.")
  }
}

object Exer06 extends App {
  val checkerThread = new Thread(checkerTask, "CHECKER")
  val setterThread = new Thread(setterTask, "SETTER")
  
  print("Starting checker thread... ")
  checkerThread.start(); println("READY")
  print("Starting setter thread... ")
  setterThread.start(); println("READY")
}