package exercises.c06_objects

object PlayingCardSuits extends Enumeration {
  
  val CLUB = Value("♣")
  val DIAMOND = Value("♦")
  val HEART = Value("♥")
  val SPADE = Value("♠")
  
  def isRed(suit: Value) = {
    suit match {
      case CLUB => false
      case DIAMOND => true
      case HEART => true
      case SPADE => false
    }
  }
}