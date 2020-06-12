package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p10Spec extends FlatSpec with Matchers {

  behavior of "foldLeft"

  it should "compute the sum of a list of numbers" in {
    val input = List(1, 2, 3)
    List.foldLeft(input, 0)(_ + _) shouldEqual 6
  }

  it should "compute the product of a list of numbers" in {
    val input = List(1, 2, 3)
    List.foldLeft(input, 1.0)(_ * _) shouldEqual 6.0
  }

}