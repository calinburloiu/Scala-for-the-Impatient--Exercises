package test

import scala.util.Random
import scala.math._

object TwiceTest extends Application {
  
  @throws(classOf[java.io.IOException])
  def wordCount(fileName: String) = {
    val in = new java.util.Scanner(new java.io.File(fileName))
    var word: String = null
    var count: Int = 0
    val map = collection.mutable.HashMap[String, Int]()
    
    while (in.hasNext()) {
      word = in.next().toLowerCase()
      count = map.getOrElse(word, 0) + 1
      map put (word, count)
    }
    
    map
  }

//  println(wordCount("facts.txt")
//      .map((t: (String, Int)) => t._2 + "\t" + t._1)
//      .mkString("\n"))

}