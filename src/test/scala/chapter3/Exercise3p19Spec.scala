package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p19Spec extends FlatSpec with Matchers {

  behavior of "filter"

  it should "remove odd numbers from a list" in {
    val list = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    List.filter(list)( _ % 2 != 0 ) shouldEqual List(0, 2, 4, 6, 8)
  }

}