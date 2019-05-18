package lectures.oop

object OOBasics extends App{
  val person = new Person("Subinoy",34)
  println(person.name, person.age)
}

class Person(val name: String, val age: Int) {

}
