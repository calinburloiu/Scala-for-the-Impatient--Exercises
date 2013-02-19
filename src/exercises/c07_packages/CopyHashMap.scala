// Exer06
package exercises.c07_packages

import java.util.{ HashMap => JavaHashMap }
import collection.mutable.{ HashMap => ScalaHashMap }

object CopyHashMap extends App {

  def copy(javaMap: JavaHashMap[Char, Int],
      scalaMap: ScalaHashMap[Char, Int]) {
    val it = javaMap.entrySet.iterator()
    var entry: java.util.Map.Entry[Char, Int] = null

    while (it.hasNext) {
      entry = it.next()
      scalaMap(entry.getKey) = entry.getValue
    }
  }

  val javaMap = new JavaHashMap[Char, Int]
  javaMap.put('a', 1)
  javaMap.put('b', 2)
  javaMap.put('c', 3)
  
  val scalaMap = new ScalaHashMap[Char, Int]
  copy(javaMap, scalaMap)
  println(scalaMap)
}