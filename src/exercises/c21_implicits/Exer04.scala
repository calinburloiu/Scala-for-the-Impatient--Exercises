// Exer04
package exercises.c21_implicits

abstract class TypeToObtain { type t }
object aString extends TypeToObtain { type t = String }
object anInt extends TypeToObtain { type t = Int }
object aDouble extends TypeToObtain { type t = Double }

class ReadDsl(val what: TypeToObtain) {
  def askingFor(ask: String): this.type = {
    print(ask + ": ")
    
    val value = what match {
      case `aString` => readLine
      case `anInt` => readInt
      case `aDouble` => readDouble
    }
    println("You wrote " + value)
    
    this
  }
  
  def and(what: TypeToObtain) = Obtain(what)
}

object Exer04 extends App {
  // Does not work with Obtain without parentheses: "Obtain aString".
  Obtain(aString) askingFor "Your name" and anInt askingFor "Your age" and aDouble askingFor "Your weight"
}