package lectures.basics

object Functions extends App {
  def aFunction(a: String, b: Int):String = {
    a + " " + b
  }

  def aParameterLessFunction():String = "Nothing"

  def aRepeatedFunction(str: String,n: Int): String = {
    if(n==1)
      str
    else
      str + aRepeatedFunction(str, n-1)
  }

  def aRepeatedFunctionFactorial(n: Double):Double = {
    if(n<=1) 1
    else n*aRepeatedFunctionFactorial(n-1)
  }

  def aRepeatedFunctionFibonacci(n: Double):Double = {
    if(n==0) 0 //Value of Fibonacci n0 = 0
    else if (n==1) 1 //Value of Fibonacci n1 = 1
    else aRepeatedFunctionFibonacci(n-1)+aRepeatedFunctionFibonacci(n-2)
  }

  def aRepeatedFunctionCheckPrime(n: Double, i: Double = 2):Boolean = {
    if(n<=2)
      if(n==2)
        return true
      else
        return false
    else
    if(n%i==0)
      return false
    if(i*i>n)
      return true

    aRepeatedFunctionCheckPrime(n,i+1)
  }

  def aRepeatedFunctionCheckPrime2(n: Int):Boolean = {
    def checkPrimeUntil(i:Int):Boolean = {
      if(i<=1) true
      else n%i!=0 && checkPrimeUntil(i-1)
    }
    checkPrimeUntil(n/2)
  }

  //  println(aFunction("Roy",1))
  //  println(aParameterLessFunction())
  //  println(aParameterLessFunction)
  //  println(aRepeatedFunction("Roy",3))
  //  println(aRepeatedFunctionFactorial(4))
  //  println(aRepeatedFunctionFibonacci(9))
  //  println(aRepeatedFunctionCheckPrime(8))
  //  println(aRepeatedFunctionCheckPrime(9))
  //  println(aRepeatedFunctionCheckPrime(10))
  //  println(aRepeatedFunctionCheckPrime(11))
  println(aRepeatedFunctionCheckPrime2(7))

}
