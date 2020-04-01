package chapter2

import scala.annotation.tailrec

object Exercise2p2 {

  @tailrec
  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    if (as.length > 1) {
      val current = as.head
      val next = as(1)

      if (ordered(current, next)) isSorted(as.tail, ordered)
      else false
    }
    else true
  }

}