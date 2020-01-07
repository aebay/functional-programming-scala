package chapter2

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}

object Exercise2p1 {

  def fibonacci(n: Int): Try[Int] = {

    @tailrec
    def incrementSequence(previous: Int, current: Int, n: Int): Int = {

      val next = previous + current

      if ( n > 0 ) incrementSequence(current, next, n-1)
      else next

    }

    n match {
      case invalidN if n < 1 => Failure(new ArrayIndexOutOfBoundsException(s"Cannot compute Fibonacci sequences for n=$invalidN"))
      case 1 => Success(0)
      case 2 => Success(1)
      case _ => Success(incrementSequence(0, 1, n-3))
    }

  }

}
