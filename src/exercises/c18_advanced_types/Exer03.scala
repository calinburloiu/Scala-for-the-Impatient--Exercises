// Exer03
package exercises.c18_advanced_types

class DocumentProperty
object Title extends DocumentProperty
object Author extends DocumentProperty

class Document {
  private var useNextArgAs: Any = null
  var title = ""
  var author = ""
  
  def set(obj: DocumentProperty): this.type = { useNextArgAs = obj; this }
  def to(arg: String): this.type = {
    useNextArgAs match {
      case next: Title.type => title = arg
      case next: Author.type => author = arg
    }
    
    this
  }

  override def toString = "\"" + title + "\", " + author
}
