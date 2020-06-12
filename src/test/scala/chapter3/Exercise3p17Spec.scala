package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p17Spec extends FlatSpec with Matchers {

  behavior of "doubleToString"

  it should "double values to strings" in {
    val list = List(1.1, 2.22, 3.333)
    List.doubleToString(list) shouldEqual List("1.1", "2.22", "3.333")
  }

}