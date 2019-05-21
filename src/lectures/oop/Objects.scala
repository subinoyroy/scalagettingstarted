package lectures.oop

object Objects
//  extends App
{
  //Scala has no STATIC
  //You can use Object and access the fields inside
  //Scala Objects are Singleton

  object Person {
    val N_EYES = 2
  }
  class Person(val name: String) {
    def nameIs():String = name
  }

  def main(args: Array[String]) = {
    val roy = Person
    val robin = Person
    println(robin==roy)

    val royClass = new Person("Roy")
    val robinClass = new Person("Robin")

    println(royClass==robinClass)

    println(royClass.nameIs())
    println(robinClass.nameIs())

    println("Called from inside main")
  }
}
