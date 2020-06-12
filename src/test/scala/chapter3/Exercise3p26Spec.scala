package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p26Spec extends FlatSpec with Matchers {

  behavior of "max"

  it should "calculate the maximum value in a tree populated with integers" in {
    val tree = Branch(Branch(Leaf(1), Leaf(3)), Leaf(2))
    Tree.maximum(tree) shouldEqual 3
  }

}