package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p6Spec extends FlatSpec with Matchers {

  behavior of "init"

  it should "return an empty list for an input empty list" in {
    val input = Nil
    List.init(input) shouldBe Nil
  }

  it should "return an empty list for a list with one element" in {
    val input = List(1)
    List.init(input) shouldBe Nil
  }

  it should "return a list with the last element missing for a given input list" in {
    val input = List(1, 2, 3, 4, 5)
    List.init(input) shouldBe List(1, 2, 3, 4)
  }

}