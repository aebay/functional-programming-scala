package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p23Spec extends FlatSpec with Matchers {

  behavior of "zipWith"

  it should "add together corresponding integers in two lists" in {
    val list1 = List(1, 2, 3)
    val list2 = List(4, 5, 6)
    List.zipWith(list1, list2)((a: Int, b: Int) => a + b ) shouldEqual List(5, 7, 9)
  }

  it should "create tuples of corresponding integers in two lists" in {
    val list1 = List(1, 2, 3)
    val list2 = List(4, 5, 6)
    List.zipWith(list1, list2)((a: Int, b: Int) => (a, b) ) shouldEqual List((1,4), (2,5), (3,6))
  }

}