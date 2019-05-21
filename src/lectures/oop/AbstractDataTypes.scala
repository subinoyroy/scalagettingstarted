package lectures.oop

object AbstractDataTypes extends App {
  abstract class Animal{
    val creatureType:String
    def eat:Unit
  }

  class Dog extends Animal{
    val creatureType: String = "Dog"
    def eat: Unit = println("Nom Nom Nom")
  }

//  trait
}
