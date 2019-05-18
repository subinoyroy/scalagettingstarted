package lectures.basics

import scala.annotation.tailrec

object DefaultValues extends App {
  @tailrec
  def fibonacciBottomUp(fibonacciNoAt: Int, n1: Int = 0, n2: Int = 1, accumulator: Int = 0, counter: Int = 1): Int = {
    if (counter == fibonacciNoAt) accumulator
    else fibonacciBottomUp(fibonacciNoAt, n2, n1 + n2, n1 + n2, counter + 1)
  }

  println(fibonacciBottomUp(21))

}
