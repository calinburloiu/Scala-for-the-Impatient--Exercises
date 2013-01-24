package exercises.c12_functions
import javax.swing._
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class MyFrame extends JFrame("Fereastră") {
  implicit def makeAction(f: (ActionEvent) => Unit): ActionListener = {
    new ActionListener {
      override def actionPerformed(event: ActionEvent) { f(event) }
    }
  }
  
  var count = 0
  this.setSize(640, 480)
  val button = new JButton("Incrementează")
  button.addActionListener(increment _)
  this.add(button)
  
  def increment(event: ActionEvent) {
    count += 1
    setTitle("" + count)
  }
}

object SAM extends App {
  (new MyFrame).setVisible(true)

}