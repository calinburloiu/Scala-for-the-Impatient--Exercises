package test

class Counter(private var value: Int = 0) {
  def increment() {
    if (value < Int.MaxValue) value += 1
  }
  
  def current = value
}
