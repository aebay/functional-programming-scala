package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p13Spec extends FlatSpec with Matchers {

  behavior of "foldLeftByFoldRight"

  it should "compute the sum of a list of numbers" in {
    val input = List(1, 2, 3)
    List.foldLeftByFoldRight(input, 0)(_ + _) shouldEqual 6
  }

  behavior of "foldRightByFoldLeft"

  it should "compute the sum of a list of numbers" in {
    val input = List(1, 2, 3)
    List.foldRightByFoldLeft(input, 0)(_ + _) shouldEqual 6
  }

}