package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p22Spec extends FlatSpec with Matchers {

  behavior of "addLists"

  it should "add together corresponding integers in two lists" in {
    val list1 = List(1, 2, 3)
    val list2 = List(4, 5, 6)
    List.addLists(list1, list2) shouldEqual List(5, 7, 9)
  }

}