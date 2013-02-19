// Exer05
package exercises.c11_operators

object Table {
  def apply(html: String = "<table><tr>") = new Table(html)
}

class Table(html: String = "<table><tr>") {
  override val toString = html + "</tr></table>"
  
  def |(col: String) = Table(html + "<td>" + col + "</td>")
  def ||(col: String) = Table(html + "</tr><tr><td>" + col + "</td>")
}