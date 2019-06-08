package exercises

abstract class RoyList {
  def head:Int

  def tail: RoyList

  def isEmpty: Boolean

  def add(data:Int): RoyList

  def printElements: String

  override def toString: String = s"[$printElements]"
}

object emptyList extends RoyList{
  def add(data:Int):RoyList = new consList(data, emptyList)

  def head:Int = throw new NoSuchElementException

  def tail: RoyList = throw new NoSuchElementException

  def isEmpty: Boolean = true

  override def printElements: String = "<empty>"
}

class consList(h:Int, t:RoyList) extends RoyList{
  override def head: Int = h

  override def tail: RoyList = t

  override def isEmpty: Boolean = false

  override def add(data: Int): RoyList = new consList(data,this)

  override def printElements: String = {
    if(this.isEmpty) ""
    else h + "[" + tail.printElements + "]"
  }
}

object Ex2 extends App{

  var list:RoyList = new consList(1,emptyList)
  list = list.add(2)
  list = list.add(3)
  list = list.add(4)
  list = list.add(5)
  list = list.add(6)
  println(list.tail)

  println(list.printElements)

  println(list.toString)

}



