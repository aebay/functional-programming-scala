package chapter2

import org.scalatest.{FlatSpec, Matchers}
import Exercise2p3.curry

class Exercise2p3Spec extends FlatSpec with Matchers {

  behavior of "Exercise2p3"

  it should "return a partial function that converts A to a function of B and C" in {

    def inputFunction(A: Int, B: Int): Boolean = if (A > B) true else false

    def outputFunction = curry(inputFunction)

    inputFunction(1,2) shouldEqual outputFunction(1)(2)

  }

}
