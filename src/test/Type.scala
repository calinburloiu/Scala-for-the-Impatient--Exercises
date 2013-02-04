package test
import scala.collection.mutable.ArrayBuffer

object Network {
  def process[M <: n.Member forSome { val n: Network }](m1: M, m2: M) = (m1, m2)
  def process2[M <: Network#Member](m1: M, m2: M) = (m1, m2)
}

class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Network#Member]
    override val toString = name
  }
  
  protected val members = new ArrayBuffer[Member]
  
  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}

trait Group {
  outer: Network =>
    class Cici {
      def gigi { println("" + outer.members(0)) }
    }
    
    def getMembers = members
}

object Type extends App {
  val chatter = new Network
  val myFace = new Network
  
  val fred = new chatter.Member("Fred")
  val wilma = new chatter.Member("Wilma")
  val barney = new myFace.Member("Barney")
  
  fred.contacts += barney
  fred.contacts += wilma
  
  Network.process(fred, wilma)
  Network.process2(fred, wilma)
//  Network.process(fred, barney) // ERROR
  Network.process2(fred, barney)
  
}