// Exer01
// Exer02
package exercises.c06_objects

object Conversions {
  def inchesToCentimeters(inches: Double) = inches * 2.54
  
  def gallonsToLiters(gallons: Double) = gallons *  3.78541
  
  def milesToKilometers(miles: Double) = miles * 1.60934
}

abstract class UnitConversion {
  val coef: Double
  
  def convert(input: Double) = input * coef
}

object InchesToCentimeters extends UnitConversion {
  val coef = 2.54
}

object GallonsToLiters extends UnitConversion {
  val coef = 3.78541
}

object MilesToKilometers extends UnitConversion {
  val coef = 1.60934
}