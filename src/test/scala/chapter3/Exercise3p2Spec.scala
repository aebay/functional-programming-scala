package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p2Spec extends FlatSpec with Matchers {

  "A list (when empty)" should "return an empty list" in {
    val list = Nil
    List.tail(list) shouldEqual Nil
  }

  "A list (with a single element)" should "return an empty list" in {
    val list = List(1)
    List.tail(list) shouldEqual Nil
  }

  "A list (with multiple elements)" should "return the list with the first element removed" in {
    val list = List(1, 2, 3, 4, 5)
    List.tail(list) shouldEqual List(2, 3, 4, 5)
  }

}