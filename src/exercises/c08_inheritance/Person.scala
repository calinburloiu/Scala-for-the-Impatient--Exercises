package exercises.c08_inheritance

class Person(val name: String) {
  override def toString = getClass().getName() + "[name=%s]".format(name)
}

class SecretAgent(codename: String) extends Person(codename) {
  override val name = "secret"
  override val toString = "secret"
}