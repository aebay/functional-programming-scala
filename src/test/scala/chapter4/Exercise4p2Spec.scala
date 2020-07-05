package chapter4

import org.scalatest.{FlatSpec, Matchers}

class Exercise4p2Spec extends FlatSpec with Matchers {

  behavior of "variance"

  it should "calculate the variance for a sequence with valid numbers" in {

    val numbers = Seq(1.0, 2.0, 3.0)

    Maths.variance(numbers) shouldBe Some(2.0/3.0)

  }

  it should "return None for an empty sequence" in {

    val numbers = Seq.empty[Double]

    Maths.variance(numbers) shouldBe None

  }
}