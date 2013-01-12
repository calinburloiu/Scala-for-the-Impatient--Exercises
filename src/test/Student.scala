package test
import scala.reflect.BeanProperty

class Student(@BeanProperty var name: String, @BeanProperty var id: Int) {

}