package chapter4

import org.scalatest.{FlatSpec, Matchers}

class Exercise4p1Spec extends FlatSpec with Matchers {

  behavior of "map"

  it should "apply the transform to each element" in {

  }

  behavior of "flatMap"

  it should "apply the transform to each element and return a flattened list" in {

  }

  it should "remove transformation results of None" in {

  }

  behavior of "getOrElse"

  it should "return the value if it exists" in {

  }

  it should "return None if the value doesn't exist" in {

  }

  behavior of "orElse"

  it should "return the first option if it's defined" in {

  }

  it should "return the second option if the first is not defined" in {

  }

}
