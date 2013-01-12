package test2.test3

class Resource {
  protected var x_ = 0
  protected var y_ = 0
  
  def x = x_
  protected[test3] def x_=(x: Int) { x_ = x }
  
  def y = y_
  protected[test3] def y_=(y: Int) { y_ = y }
}

class Repo {
  def incX(r: Resource) {
    r.x += 1
  }
}