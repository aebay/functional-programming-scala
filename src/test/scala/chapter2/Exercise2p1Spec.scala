package chapter2

import org.scalatest.{FlatSpec, Matchers}

import scala.util.Try
import Exercise2p1.fibonacci

class Exercise2p1Spec extends FlatSpec with Matchers {

  behavior of "fibonacci"

  it should "return 0 for the first number in the Fibonacci sequence" in {
    fibonacci(1) shouldEqual Try(0)
  }

  it should "return 1 for the second number in the Fibonacci sequence" in {
    fibonacci(2) shouldEqual Try(1)
  }

  it should "return 1 for the third number in the Fibonacci sequence" in {
    fibonacci(3) shouldEqual Try(1)
  }

  it should "return 2 for the fourth number in the Fibonacci sequence" in {
    fibonacci(4) shouldEqual Try(2)
  }

  it should "return 3 for the fifth number in the Fibonacci sequence" in {
    fibonacci(5) shouldEqual Try(3)
  }

  it should "return 34 for the tenth number in the Fibonacci sequence" in {
    fibonacci(10) shouldEqual Try(34)
  }

  it should "return failure for a zero Fibonacci sequence index" in {

    fibonacci(0).isFailure shouldBe true

  }

  it should "return failure for a negative Fibonacci sequence index" in {

    fibonacci(-1).isFailure shouldBe true

  }

}
