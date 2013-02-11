// Exer02
package exercises.c15_annotations

@deprecated
class AnnotationsPositions[@deprecated T] @deprecated() (x: T) {
  @deprecated
  var field: AnyRef @deprecated = null
  
  @deprecated
  type S = T
  
  @deprecated
  def method(@deprecated @deprecatedName('argument) arg: Any): Any = {
    @deprecated
    var local: Any = null
    
    (1 + 1): @deprecated
    
    (local: @deprecated) match {
      case x: String => "It's a String :-D"
      case x: Any => "Don't know what's this :-("
    }
  }
}