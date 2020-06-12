package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p16Spec extends FlatSpec with Matchers {

  behavior of "increment"

  it should "increment all list values by 1" in {
    val list = List(1, 2, 3)
    List.increment(list) shouldEqual List(2, 3, 4)
  }

}