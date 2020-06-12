package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p28Spec extends FlatSpec with Matchers {

  behavior of "map"

  it should "convert all leaf elements" in {
    val tree = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
    Tree.map(tree)( _ * 2) shouldBe Branch(Branch(Leaf(2), Leaf(4)), Leaf(6))
  }

}