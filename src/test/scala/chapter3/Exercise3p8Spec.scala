package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p8Spec extends FlatSpec with Matchers {

  behavior of "foldRight"

  it should "decompose a list into nested components" in {
    val input = List(1, 2, 3)
    List.foldRight(input, Nil: List[Int])(Cons(_,_)) shouldBe Cons(1, Cons(2, Cons(3, Nil)))
  }

}