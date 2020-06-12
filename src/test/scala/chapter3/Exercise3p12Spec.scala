package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p12Spec extends FlatSpec with Matchers {

  behavior of "reverse"

  it should "reverse a list" in {
    val input = List(1, 2, 3)
    List.reverse(input) shouldBe List(3, 2, 1)
  }

  it should "return an empty list for an empty list" in {
    val input = Nil
    List.reverse(input) shouldEqual Nil
  }

}