package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p25Spec extends FlatSpec with Matchers {

  "The size of a tree with one leaf" should "be one node" in {
    val tree = Leaf(1)
    Tree.size(tree) shouldEqual 1
  }

  "The size of a tree with one branch" should "be three nodes" in {
    val tree = Branch(Leaf(1), Leaf(2))
    Tree.size(tree) shouldEqual 3
  }

  "The size of a tree with two branches" should "be five nodes" in {
    val tree = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
    Tree.size(tree) shouldEqual 5
  }

}