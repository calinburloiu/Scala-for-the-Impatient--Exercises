// Exer06
package exercises.c20_actors
import scala.actors.Actor

class ReceiveActor extends Actor {
  def act() {
    while (true) {
      receive {
        case 'Hello => println(this.getClass.getSimpleName + ": " + Thread.currentThread)
      }
    }
  }
} 

class ReactActor extends Actor {
  def act() {
    loop {
      react {
        case 'Hello => println(this.getClass.getSimpleName + ": " + Thread.currentThread)
      }
    }
  }
}

object Exer06 extends App {  
  // Actors with while/receive
  for (i <- 1 to 100) {
    val actor = new ReceiveActor
    actor.start()
    actor ! 'Hello
  }
  
  // Actors with loop/react
  for (i <- 1 to 100) {
    val actor = new ReactActor
    actor.start()
    actor ! 'Hello
  }
  
  println("main: " + Thread.currentThread)
}