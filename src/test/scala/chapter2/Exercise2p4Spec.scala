package chapter2

import Exercise2p4.uncurry
import org.scalatest.{FlatSpec, Matchers}

class Exercise2p4Spec extends FlatSpec with Matchers {

  behavior of "Exercise2p4"

  it should "return an uncurried function of two input arguments" in {

    def curriedFunction(A: Int)(B: Int): Boolean = if (A > B) true else false

    def uncurriedFunction = uncurry(curriedFunction)

    curriedFunction(1)(2) shouldEqual uncurriedFunction(1,2)

  }

}
