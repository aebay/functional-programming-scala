package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p18Spec extends FlatSpec with Matchers {

  behavior of "map"

  it should "convert double values to strings" in {
    val list = List(1.1, 2.22, 3.333)
    List.map(list)( _.toString ) shouldEqual List("1.1", "2.22", "3.333")
  }

  it should "increment all list values by 1" in {
    val list = List(1, 2, 3)
    List.map(list)( _ + 1) shouldEqual List(2, 3, 4)
  }

}