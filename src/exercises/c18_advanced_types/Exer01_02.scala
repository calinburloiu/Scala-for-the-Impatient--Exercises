// Exer01
// Exer02
package exercises.c18_advanced_types

object Show
object Then
object Around

class Bug {
  private var pos = 0
  private var direc = 1
  
  
  def show(): this.type = { println(pos); this }
  def move(steps: Int): this.type = { pos += steps * direc; this }
  def turn(): this.type = { direc *= -1; this }
  
  def and(showLah: Show.type): this.type = show()
  def and(thenLah: Then.type): this.type = this
  def turn(aroundLah: Around.type): this.type = turn()
}
