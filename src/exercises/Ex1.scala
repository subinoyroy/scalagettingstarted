package exercises

object Ex1 extends App{
  abstract class MyList {
    val head:Node
    class Node(val data:Int) {
      val next:Node = new Node(data)
    }
  }



}
