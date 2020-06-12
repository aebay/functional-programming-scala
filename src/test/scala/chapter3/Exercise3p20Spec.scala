package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p20Spec extends FlatSpec with Matchers {

  behavior of "flatMap"

  it should "return a list for a given input and flatten the list" in {
    val list = List(1, 2, 3)
    List.flatMap(list)(i => List(i, i)) shouldEqual List(1, 1, 2, 2, 3, 3)
  }

}