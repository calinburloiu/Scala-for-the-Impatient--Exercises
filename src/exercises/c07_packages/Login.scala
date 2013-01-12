package exercises.c07_packages

import java.lang.System

object Login extends App {
  val props = System.getProperties()
  
  val username = props.getProperty("user.name")
  if (username == null) {
    Console.err.println("No username provided.")
    System.exit(1)
  }
  
  val password = Console.readLine
  if (password == "secret") {
    println("Welcome, " + username + "!")
  } else {
    Console.err.println("Wrong password!")
  }
}