package exercises

abstract class RoyListGeneric[+A] {
  def head:A

  def tail: RoyListGeneric[A]

  def isEmpty: Boolean

  def add[B >:A](data:B): RoyListGeneric[B]

  def printElements: String

  override def toString: String = s"[$printElements]"
}

object emptyListGeneric extends RoyListGeneric[Nothing]{
  def add[B >:Nothing](data:B):RoyListGeneric[B] = new consListGeneric(data, emptyListGeneric)

  def head:Nothing = throw new NoSuchElementException

  def tail: RoyListGeneric[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  override def printElements: String = "<empty>"
}

class consListGeneric[+A](h:A, t:RoyListGeneric[A]) extends RoyListGeneric[A] {
  def head:A = h

  def tail: RoyListGeneric[A] = t

  def isEmpty: Boolean = false

  def add[B>:A](data: B): RoyListGeneric[B] = new consListGeneric(data,this)

  def printElements: String = {
    if(this.isEmpty) ""
    else h + "[" + tail.printElements + "]"
  }
}

object GenericEx extends App{

  var list:RoyListGeneric[String] = new consListGeneric("A",emptyListGeneric)
  list = list.add("B")
  list = list.add("C")
  list = list.add("D")
  list = list.add("E")
  list = list.add("F")
  println(list.toString)

  val list1:RoyListGeneric[Int] = new consListGeneric(1,new consListGeneric(2,new consListGeneric(3,new consListGeneric(4,emptyListGeneric))))
  println(list1.toString)


}