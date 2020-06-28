package chapter4

import org.scalatest.{FlatSpec, Matchers}

class Exercise4p1Spec extends FlatSpec with Matchers {

  private val some = Some(1)
  private val none = None

  behavior of "map"

  it should "apply the transform to a non-empty option" in {
    some map( _*2 ) shouldEqual Some(2)
  }

  it should "ignore the transform for an empty option" in {
    none map( x => x ) shouldEqual None
  }

  behavior of "flatMap"

  it should "apply the transform to an non-empty option" in {
    some flatMap( x => Some(x*2) ) shouldEqual Some(2)
  }

  it should "ignore the transform for an empty option" in {
    none flatMap( _ => Some(3) ) shouldEqual None
  }

  behavior of "getOrElse"

  it should "return the option value for a non-empty option" in {
    some getOrElse 3 shouldEqual 1
  }

  it should "return the default value for an empty option" in {
    none getOrElse 3 shouldEqual 3
  }

  behavior of "orElse"

  it should "return the option for a non-empty option" in {
    some orElse Some(3) shouldEqual Some(1)
  }

  it should "return the default option for an empty option" in {
    none orElse Some(3) shouldEqual Some(3)
  }

  behavior of "filter"

  it should "return the option if the predicate is satisfied" in {
    some filter( _ == 1 ) shouldEqual Some(1)
  }

  it should "return an empty option if the predicate is not satisfied" in {
    some filter( _ == 3 ) shouldEqual None
  }

  it should "return an empty option if the option is empty" in {
    none filter( _ == 3 ) shouldEqual None
  }

}