package exercises

abstract class MyList {
  def head:Int
  def tail: MyList
  def isEmpty: Boolean
  def add(data:Int): MyList
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList{
  override def head: Int = throw new NoSuchElementException

  override def tail: MyList = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add(data: Int): MyList = new Cons(data, Empty)

  override def printElements: String = ""
}

class Cons(h:Int, t:MyList) extends MyList {
  override def head: Int = h

  override def tail: MyList = t

  override def isEmpty: Boolean = false

  override def add(data: Int): MyList = new Cons(data, this)

  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
}

object Ex1 extends App{

  val list:Cons = new Cons(1,new Cons(2,new Cons(3,Empty)))
  System.out.println(list.head)
  System.out.println(list.tail.head)
  System.out.println(list.tail.tail.head)

  println(list.toString());
}
