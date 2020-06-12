package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p9Spec extends FlatSpec with Matchers {

  behavior of "length"

  it should "return zero for an empty list" in {
    val input = Nil
    List.length(input) shouldEqual 0
  }

  it should "return the number of elements in a populated list" in {
    val input = List(1, 2, 3, 4, 5)
    List.length(input) shouldEqual 5
  }


}