package chapter2

import org.scalatest.{FlatSpec, Matchers}
import Exercise2p2.isSorted

class Exercise2p2Spec extends FlatSpec with Matchers {

  behavior of "isSorted"

  it should "validate whether a numerical list is sorted" in {

    val orderedList = Array(1, 2, 3, 4, 6)
    val unorderedList = Array(4, 5, 2, 1)

    def nextNumberIsHigher(A: Int, B: Int): Boolean = if (A < B) true else false
    def nextNumberIsLower(A: Int, B: Int): Boolean = if (A > B) true else false

    isSorted(orderedList, nextNumberIsHigher) shouldBe true
    isSorted(orderedList, nextNumberIsLower) shouldBe false
    isSorted(unorderedList, nextNumberIsHigher) shouldBe false

  }

  it should "validate whether a string list is sorted" in {

    val orderedList = Array("I", "am", "near", "Castle", "Frankenstein")

    def nextWordIsLonger(A: String, B: String): Boolean = if (A.length < B.length) true else false
    def nextWordIsShorter(A: String, B: String): Boolean = if (A.length > B.length) true else false

    isSorted(orderedList, nextWordIsLonger) shouldBe true
    isSorted(orderedList, nextWordIsShorter) shouldBe false

  }

}
