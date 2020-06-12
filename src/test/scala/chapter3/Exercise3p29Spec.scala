package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p29Spec extends FlatSpec with Matchers {

  private val tree = Branch(Branch(Leaf(1), Leaf(7)), Leaf(4))

  behavior of "fold"

  it should "count the number of nodes in a tree" in {
    Tree.foldSize(tree) shouldEqual 5
  }

  it should "return the maximum element in a tree" in {
    Tree.foldMaximum(tree) shouldEqual 7
  }

  it should "calculate the maximum path length in a tree" in {
    Tree.foldDepth(tree) shouldEqual 3
  }

  it should "convert all leaf elements" in {
    Tree.foldMap(tree)(_ * 2) shouldEqual Branch(Branch(Leaf(2), Leaf(14)), Leaf(8))
  }

}