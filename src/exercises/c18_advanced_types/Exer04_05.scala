// Exer04
// Exer05
package exercises.c18_advanced_types
import scala.collection.mutable.ArrayBuffer

object Network {
  type NetworkMember = n.Member forSome { val n: Network }
  
  def process[M <: n.Member forSome { val n: Network }](m1: M, m2: M) = (m1, m2)
  def process2[M <: Network#Member](m1: M, m2: M) = (m1, m2)
  
  def process3(m1: NetworkMember, m2: NetworkMember) = (m1, m2)
}

class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Network#Member]
    
    override def equals(that: Any) = that match {
      case t: Member => true
      case _ => false
    }
    override val toString = name
  }
  
  protected val members = new ArrayBuffer[Member]
  
  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}
