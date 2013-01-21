package exercises.c08_inheritance

class Creature {
  val range = 10
  val env = new Array[Int](range)
}

class Ant extends Creature {
  override val range = 2
}

class Bug extends {
  override val range = 3
} with Creature

object CreatureApp extends App {
  val a = new Ant
  println(a.range)
  println(a.env.length)
}