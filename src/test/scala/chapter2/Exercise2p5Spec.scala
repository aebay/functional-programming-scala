package chapter2

import Exercise2p5.compose
import org.scalatest.{FlatSpec, Matchers}

class Exercise2p5Spec extends FlatSpec with Matchers {

  behavior of "compose"

  it should "return an composed function of the two input functions" in {

    def f(B: Int): Boolean = if (B > 0) true else false
    def g(A: Int): Int = A * 2

    def composedFunction = compose(f, g)

    f(g(4)) shouldEqual composedFunction(4)

  }

}
