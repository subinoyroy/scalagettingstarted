package lectures.oop

import java.time.Year

object OOBasics extends App{
//  val person = new Person("Subinoy",34)
//  println(person.name, person.age)
//  person.tellMeName()
//  println(person.data)

  val writer = new Writer("Subinoy","Roy", Year.of(1984))
  val impostor = new Writer("Subinoy","Roy", Year.of(1984))
  val novel = new Novel("Scala did a Java thing",Year.of(2019), writer)

  println(writer.fullName())
  println(novel.authorAge())
  val novel1 = novel.copy(Year.of(2020))
  println(novel.toString)
  println(novel1.toString)

  println("Is written By: "+novel1.checkAuthor(impostor))

//  var counter = new Counter(10)
//  println(counter.n)
//  val counter1 = counter.incrementCounter()
//  println(counter1.n)
//  val counter2 = counter1.incrementCounter(10)
//  println(counter2.n)
//  val counter3 = counter2.decrementCounter(4)
//  println(counter3.n)
//  val counter4 = counter3.decrementCounter()
//  println(counter3.n)

  var counter = new Counter(10)
  println(counter.n)
  counter = counter.incrementCounter()
  println(counter.n)
  counter = counter.incrementCounter(10)
  println(counter.n)
  counter = counter.decrementCounter(4)
  println(counter.n)
  counter = counter.decrementCounter()
  println(counter.n)

}

class Person(val name: String, val age: Int) {
  println("Creating person object");

  var data = 100

  def tellMeName() = {
    println(name)
  }
}

class Writer(val firstName: String, val lastName:String, val year: Year) {
  def fullName():String = {
    s"$firstName $lastName"
  }
}

class Novel(val name: String, val yearOfRelease: Year, val author: Writer){
  def authorAge():Int = {
    yearOfRelease.compareTo(author.year)
  }

  def getWrittenBy():String = {
    return author.fullName()
  }

  def copy(pubYear: Year):Novel = {
    new Novel(name, pubYear, author)
  }

  def checkAuthor(author: Writer) = author == this.author

  override def toString(): String = s"Name: $name, yearOfRelease: $yearOfRelease, writtenBy: $getWrittenBy"

}

class Counter(val n:Int) {
  def getCurrentCount():Int = {
    n
  }

  def incrementCounter():Counter = {
    new Counter(n+1)
  }

  def decrementCounter():Counter = {
    new Counter(n-1)
  }

  def incrementCounter(by:Int):Counter = {
    //new Counter(n+by)
    if(by==0) this
    //else incrementCounter.incrementCounter(by-1)
    else incrementCounter(by-1).incrementCounter()
  }

  def decrementCounter(by:Int):Counter = {
    //new Counter(n-by)
    if(by==0) this
    else decrementCounter().decrementCounter(by-1)
  }
}