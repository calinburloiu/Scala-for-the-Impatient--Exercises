// Exer10
/*
Compile this with `scalac -Xprint:typer Exer10.scala` in order
to find out which implicit conversion is used.
*/
package exercises.c21_implicits

object FindImplicitConversion extends App {
  "abc".map(_.toUpper)
  "abc".map(_.toInt)
}
