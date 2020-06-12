package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p3Spec extends FlatSpec with Matchers {

  "A list (when empty)" should "return an empty list" in {
    val list = Nil
    val newElement: Int = 10
    List.setHead(list, newElement) shouldEqual Nil
  }

  "A list (with a single element)" should "return the list with the single element replaced" in {
    val list = List(1)
    val newElement = 10
    List.setHead(list, newElement) shouldEqual List(10)
  }

  "A list (with multiple elements)" should "return the list with the first element replaced" in {
    val list = List(1, 2, 3, 4, 5)
    val newElement = 10
    List.setHead(list, newElement) shouldEqual List(10, 2, 3, 4, 5)
  }

}