object Timer {
  
  def oncePerSecond(callback: (Int) => Unit) {
    while (true {
      callback(3)
      Thread sleep 1000
    }
  }

  def main(args : Array[String]) {
    oncePerSecond((n: Int) => println("tack " + n))
  }
}

// vim: set ts=4 sw=4 et:
