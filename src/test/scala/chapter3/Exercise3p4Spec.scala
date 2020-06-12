package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p4Spec extends FlatSpec with Matchers {

  "A list (when empty)" should "return an empty list" in {
    val list = Nil
    List.drop(list, 0) shouldEqual Nil
    List.drop(list, 1) shouldEqual Nil
    List.drop(list, 5) shouldEqual Nil
  }

  "A list (with one element)" should "return the same list" in {
    val list = List(1)
    List.drop(list, 0) shouldEqual List(1)
  }

  "A list (with one element)" should "return an empty list" in {
    val list = List(1)
    List.drop(list, 1) shouldEqual Nil
    List.drop(list, 5) shouldEqual Nil
  }

  "A list (with multiple elements)" should "return the list without the first n elements" in {
    val list = List(1, 2, 3, 4, 5)
    List.drop(list, 0) shouldEqual List(1, 2, 3, 4, 5)
    List.drop(list, 1) shouldEqual List(2, 3, 4, 5)
    List.drop(list, 5) shouldEqual Nil
  }

}