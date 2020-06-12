package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p5Spec extends FlatSpec with Matchers {

  "A list (when empty)" should "return an empty list" in {
    val list = Nil
    def filter(a: Int): Boolean = if (a < 10) true else false
    List.dropWhile(list, filter) shouldEqual Nil
  }

  "A list (with one element)" should "return an empty list" in {
    val list = List(1)
    def filter(a: Int): Boolean = if (a < 10) true else false
    List.dropWhile(list, filter) shouldEqual Nil
  }

  "A list (with one element)" should "return the original list" in {
    val list = List(1)
    def filter(a: Int): Boolean = if (a < 0) true else false
    List.dropWhile(list, filter) shouldEqual List(1)
  }

  "A list (with multiple elements)" should "return the list with elements dropped until the predicate is met" in {
    val list = List(1, 2, 3, 4, 5)
    def filter(a: Int): Boolean = if (a < 3) true else false
    List.dropWhile(list, filter) shouldEqual List(3, 4, 5)
  }

}