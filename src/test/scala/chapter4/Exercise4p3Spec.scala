package chapter4

import org.scalatest.{FlatSpec, Matchers}

class Exercise4p3Spec extends FlatSpec with Matchers {

  private val testFunction = (a: Int, b: Int) => a + b

  behavior of "map2"

  it should "calculate the function when both values are provided" in {

    Option.map2(Some(1), Some(2))(testFunction) shouldBe Some(3)

  }

  it should "return None when either of the values are missing" in {

    Option.map2(Some(1), None)(testFunction) shouldBe None
    Option.map2(None, Some(2))(testFunction) shouldBe None
    Option.map2(None, None)(testFunction) shouldBe None

  }
}