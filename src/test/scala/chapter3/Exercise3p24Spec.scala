package chapter3

import org.scalatest.{FlatSpec, Matchers}

class Exercise3p24Spec extends FlatSpec with Matchers {

  behavior of "hasSubsequence"

  it should "return false if the subsequence does not exist in the super-sequence" in {
    val superSequence = List(1, 2, 3, 4, 5)
    val subSequence = List(3, 5)
    List.hasSubsequence(superSequence, subSequence) shouldBe false
  }

  it should "return true if the subsequence exists in the ordered super-sequence" in {
    val superSequence = List(1, 2, 3, 4)
    val subSequence1 = List(1, 2)
    val subSequence2 = List(3, 4)
    val subSequence3 = List(4)

    List.hasSubsequence(superSequence, subSequence1) shouldBe true
    List.hasSubsequence(superSequence, subSequence2) shouldBe true
    List.hasSubsequence(superSequence, subSequence3) shouldBe true
  }

  it should "return true if the subsequence exists in the unordered super-sequence" in {
    val superSequence = List(1, 3, 2, 3, 4)
    val subSequence = List(3, 4)

    List.hasSubsequence(superSequence, subSequence) shouldBe true
  }

}