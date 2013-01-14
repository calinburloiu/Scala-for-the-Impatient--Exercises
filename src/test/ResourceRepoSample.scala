package test

class Resource {
  protected var x_ = 0
  protected var y_ = 0
  
  def x = x_
  protected def x_=(x: Int) { x_ = x }
  
  def y = y_
  protected def y_=(y: Int) { y_ = y }
}

trait Repo {
  this: Resource =>

    def incX(): Unit

}

trait MyRepo extends Repo {
  this: Resource =>
  
  def incX() {
    this.x_ += 1
  }
  
  def decY() {
    this.y_ -= 1
  }
}
