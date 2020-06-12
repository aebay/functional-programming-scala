package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p15Spec extends FlatSpec with Matchers {

  behavior of "appendLists"

  it should "append three lists in the order they are combined" in {
    val list1 = List(1, 2, 3)
    val list2 = List(4, 5, 6)
    val list3 = List(7, 8, 9)
    List.appendLists(List(list1, list2, list3)) shouldEqual List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  }

}