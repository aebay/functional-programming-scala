package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p11Spec extends FlatSpec with Matchers {

  behavior of "sum using foldLeft"

  it should "compute the sum of a list of numbers" in {
    val input = List(1, 2, 3)
    List.sumFoldLeft(input) shouldEqual 6
  }

  it should "return zero for an empty list" in {
    val input = Nil
    List.sumFoldLeft(input) shouldEqual 0
  }

  behavior of "product using foldLeft"

  it should "compute the product of a list of numbers" in {
    val input = List(1.0, 2.0, 3.0)
    List.productFoldLeft(input) shouldEqual 6.0
  }

  it should "return one for an empty list" in {
    val input = Nil
    List.productFoldLeft(input) shouldEqual 1
  }

  behavior of "length using foldLeft"

  it should "return the number of elements in a non-empty list" in {
    val input = List(1, 2, 3)
    List.lengthFoldLeft(input) shouldEqual 3
  }

  it should "return zero for an empty list" in {
    val input = Nil
    List.lengthFoldLeft(input) shouldEqual 0
  }

}