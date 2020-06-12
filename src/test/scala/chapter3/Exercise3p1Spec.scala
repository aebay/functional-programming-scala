package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p1Spec extends FlatSpec with Matchers {

  behavior of "pattern matching example"

  it should "return the correct match" in {

    Exercise3p1.x shouldEqual 3

  }

}
