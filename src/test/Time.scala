package test

class Time(val hours: Int, val minutes: Int) {
  
  val totalMinutes = hours * 60 + minutes
  
  def before(that: Time) = this.totalMinutes < that.totalMinutes
}