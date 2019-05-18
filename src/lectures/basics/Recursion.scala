package lectures.basics

import scala.annotation.tailrec

object Recursion extends App {
//  @tailrec
  def factorial(n: Double):Double = {
    if(n==1) return 1
    else {
      println("Trying to get factorial of "+n+". But we first need factorial of "+(n-1))
      val result: Double = n*factorial(n-1)
      println("Got factorial of "+(n))
      result
    }
  }

  def aRepeatedFunctionFibonacci(n: Double):Double = {
    if(n==0) 0 //Value of Fibonacci n0 = 0
    else if (n==1) 1 //Value of Fibonacci n1 = 1
    else aRepeatedFunctionFibonacci(n-1)+aRepeatedFunctionFibonacci(n-2)
  }

  //When you need LOOPS, use TAIL RECURSION
  def factorialNew(n: Int):BigInt = {
    @tailrec
    def factorialHelper(n: BigInt, accumulator: BigInt):BigInt = {
      if(n==1) return accumulator
      else factorialHelper(n-1,n*accumulator)//TAIL RECURSION - Use Recursive call as LAST Expression
    }
    factorialHelper(n,1)

  }

  //0 1 2 3 5 8 13 21 34 55...
  def fibonacci(n: BigInt):BigInt = {
    if(n==0) 0 //Value of Fibonacci n0 = 0
    else if (n==1) 1 //Value of Fibonacci n1 = 1
    else{
      fibonacci(n-1)+fibonacci(n-2)
    }
  }

  //3*factorial(2)
  //3*2*factorial(1)
  //3*2*1
  //println(factorialNew(6))

  def fibonacciBottomUp(x: Int):Int = {
    @tailrec
    def fibonacciHelper(n1: Int, n2:Int, accumulator: Int, counter: Int):Int = {
      if (counter==x) accumulator
      else{
        fibonacciHelper(n2, n1+n2, n1+n2, counter+1);
      }
    }
    fibonacciHelper(0, 1, 0, 1);
  }

  println(fibonacci(20));
  println(fibonacciBottomUp(30));

  def stringRepeater(txt: String, nos: Int):String = {
    def stringHelper(str: String, counter: Int, accumulator: String): String = {
      if(counter==0) accumulator
      else stringHelper(str,counter-1,accumulator+str);
    }
    stringHelper(txt, nos, "");
  }

//  println(stringRepeater("Roy",6));

  def isPrime(x: Int): Boolean ={
    @tailrec
    def primeHelper(x:Int, nextDivisor:Int):Int = {
      if(nextDivisor==1) nextDivisor
      else if(x%nextDivisor==0) nextDivisor
      else primeHelper(x, nextDivisor-1)
    }
    val retVal: Int = primeHelper(x, x/2)
    println(retVal)
    retVal ==1
  }

  println(isPrime(13))

  def isPrimeAnother(x: Int): Boolean ={
    @tailrec
    def primeHelper(n:Int, stillPrime:Boolean):Boolean = {
      if(!stillPrime) false
      else if(n==1) true
      else primeHelper(n-1, (x%n!=0 && n>=1))
    }
    primeHelper(x/2,true)
  }

  println(isPrimeAnother(2004));

}
