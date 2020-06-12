package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p14Spec extends FlatSpec with Matchers {

  behavior of "appendFoldLeft"

  it should "append two lists in the order they are combined" in {
    val input1 = List(1, 2, 3)
    val input2 = List(4, 5, 6)
    List.appendFoldLeft(input1, input2) shouldEqual List(1, 2, 3, 4, 5, 6)
  }

}