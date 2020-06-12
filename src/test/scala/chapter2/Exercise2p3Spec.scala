package chapter2

import org.scalatest.{FlatSpec, Matchers}
import Exercise2p3.curry

class Exercise2p3Spec extends FlatSpec with Matchers {

  behavior of "curry"

  it should "return a curried function of two input arguments" in {

    def uncurriedFunction(A: Int, B: Int): Boolean = if (A > B) true else false

    def curriedFunction = curry(uncurriedFunction)

    uncurriedFunction(1,2) shouldEqual curriedFunction(1)(2)

  }

}
