package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p27Spec extends FlatSpec with Matchers {

  "The depth of a tree with one leaf" should "be one" in {
    val tree = Leaf(1)
    Tree.depth(tree) shouldEqual 1
  }

  "The depth of a tree with one branch" should "be two" in {
    val tree = Branch(Leaf(1), Leaf(2))
    Tree.depth(tree) shouldEqual 2
  }

  "The depth of a tree with two branches" should "be three" in {
    val tree = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
    Tree.depth(tree) shouldEqual 3
  }

}