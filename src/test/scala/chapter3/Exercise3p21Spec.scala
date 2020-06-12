package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p21Spec extends FlatSpec with Matchers {

  behavior of "flatMapFilter"

  it should "filter integers that match the boolean statement" in {
    val list = List(0, 5, 1, 4, 3, 2)
    List.flatMapFilter(list)(_ > 2) shouldEqual List(5, 4, 3)
  }

}