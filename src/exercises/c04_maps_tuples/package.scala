package exercises

package object c04_maps_tuples {
  // Exer02
  // mutable
  @throws(classOf[java.io.IOException])
  def countWordsM(fileName: String) = {
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
  
  // Exer03
  // Exer04
  // immutable
  @throws(classOf[java.io.IOException])
  def countWordsI(fileName: String) = {
    val in = new java.util.Scanner(new java.io.File(fileName))
    var word: String = null
    var count: Int = 0
    var map = collection.immutable.SortedMap[String, Int]()
    
    while (in.hasNext()) {
      word = in.next().toLowerCase()
      count = map.getOrElse(word, 0) + 1
      map += (word -> count)
    }
    
    map
  }
}