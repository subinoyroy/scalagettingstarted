package lectures.oop

object MethodNotations extends App {
  class Person(val name: String, val favourite: String, val age:Int = 0) {
    def +(aka:String):Person = new Person(this.name+s" $aka",favourite,age)
    def unary_+ :Person = {println("Inside:   "+this.toString()); new Person(this.name,this.favourite,this.age+1)}
    def learns(lang:String) = s"$name learns $lang"
    def learnsScala = learns("Scala")
    def apply(count:Int) = println(s"$name has watched $favourite $count times")
    override def toString():String = s"$name $favourite $age"
  }

  var roy:Person = new Person("Subinoy Roy", "Gangs of Wasseypur",34)
//  println(roy.toString())
//  roy = roy + "Babu"
//  println(roy.toString())
//  roy = +roy
//  println(roy.toString())
  println(roy learns "Java")
  println(roy learnsScala)
//  roy.apply(12)

  (+(roy+"Babu")).apply(12)
  println(roy.toString())
}
