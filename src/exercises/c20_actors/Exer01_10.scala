// Exer01
// Exer10
/*
 * A set of n random numbers will be generated which are going to be split into
 * initSplit bales. A set of initSplit actors out of a pool of initSplit*2 - 1
 * will receive a bale each and compute the sum of the numbers in the bale,
 * additionally counting them.
 * Each of this actors is numbered with an ID of even number starting from 0.
 * Each pair of consecutive actors will send the result to another actor which has
 * the ID the average of its parents IDs. In the end a single actor with ID
 * initSplit - 1 will receive one sum. It will divide it by the count, thus
 * calculating the average and it will print it.
 */
package exercises.c20_actors
import scala.actors.Actor
import scala.actors.Channel
import scala.actors.!

case class Message(array: Array[BigInt], count: Int)

class WorkerActor(val id: Int, val child: WorkerActor) extends Actor {
  val channel = new Channel[Message](child)
  var balesReceived = 0
  var sum: BigInt = 0
  var count = 0
  
  def act() {
    while (true) {
      receive {
        case _ ! Message(arr, cnt) => {
//          println("%s: Recv %s cnt=%d".
//              format(this.toString, if (arr.size > 0) "a="+arr(0) else "", cnt ))
          balesReceived += 1
          sum += arr.sum
          count += (if (cnt == 0) arr.size else cnt)
          
          if (balesReceived == 2) {
            if (child != null)
              channel ! Message(Array(sum), count)
            else 
              println ("Average is " + sum.toDouble / count)
            exit()
          }
        }
      }
    }
  }
  
  override val toString = "w" + id

}

/**
 * Calculate the average of n random numbers.
 * 
 * @param n How many random number are going to be generated? (power of 2)
 * @param initSplit In how many pieces is going to be the problem split initially?
 * (power of 2 and divisor of n)
 */
class CalcAvg(n: Int, initSplit: Int) {
  // The number of actors
  val m = initSplit * 2 - 1
  val actors = new Array[WorkerActor](m)
  val data = new Array[BigInt](n)
  
  def log2(x: Int): Int = (math.log(x) / math.log(2)).toInt
  def pow2(x: Int): Int = math.pow(2, x).toInt
  
  def createActors() {
    for (step <- (log2(initSplit) + 1) to (1, -1)) {
      val dist = pow2(step)
      val start = pow2(step - 1) - 1
      
      var left = true
      for (id <- start until (m, dist)) {
        val childId = if (left) id + dist / 2 else id - dist / 2 
        actors(id) = new WorkerActor(id, if (childId < m) actors(childId) else null)
        actors(id).start()
        left = if (left) false else true
      }
    }
  }
  
  def createData() {
    var x = 1
    for (i <- 0 until n) {
      data(i) = x
      x += 1
    }
  }
  
  def start() {
    createActors()
    createData()
    
    for (i <- 0 until m if i % 2 == 0) {
      val j = i/2
      val from = j*(n / initSplit)
      val to = (j + 1)*(n / initSplit)
      
      new Channel[Message](actors(i)) ! Message(data.slice(from, to), 0)
      new Channel[Message](actors(i)) ! Message(Array[BigInt](), 0)
    }
  }
}

object Exer01 extends App {
//  val ca = new CalcAvg(2 * 1024 * 1024, 8)
  val ca = new CalcAvg(args(0).toInt, args(1).toInt)
  ca.start()
}