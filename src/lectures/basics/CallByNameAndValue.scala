package lectures.basics

object CallByNameAndValue extends App {

  def callByValue(x: Long): Unit ={
    println("By Value: "+ x);
    println("By Value: "+ x);
  }

  def callByName(x: => Long): Unit ={
    println("By Name: "+ x);
    println("By Name: "+ x);
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinity():Int = 1+infinity()

  //x is evaluated first and then used. y is not evaluated until it is used.
  def testFunction(x:Int, y: => Int):Unit = {
    println(x)
  }

  //testFunction(infinity(),10);//Stack Overflow Error
  testFunction(10,infinity());//No Error

}
