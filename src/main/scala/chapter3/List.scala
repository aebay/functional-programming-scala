package chapter3

import scala.annotation.tailrec

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(doubles: List[Double]): Double = doubles match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def tail[A](list: List[A]): List[A] = list match {
    case Nil => Nil
    case Cons(_, tail) => tail
  }

  @tailrec
  def drop[A](list: List[A], n: Int): List[A] = {
    if (n<=0) list
    else {
      list match {
        case Nil => Nil
        case Cons(_, tail) => drop(tail, n - 1)
      }
    }
  }

  @tailrec
  def dropWhile[A](list: List[A], f: A => Boolean): List[A] = list match {
    case Cons(head, tail) if f(head) => dropWhile(tail, f)
    case _ => list
  }

  def setHead[A](list: List[A], head: A): List[A] = list match {
    case Nil => Nil
    case Cons(_, tail) => Cons(head, tail)
  }

  def append[A](list1: List[A], list2: List[A]): List[A] = list1 match {
    case Nil => list2
    case Cons(head, tail) => Cons(head, append(tail, list2))
  }

  def appendFoldLeft[A](list1: List[A], list2: List[A]): List[A] = {
    val reversedList1 = reverse(list1)
    foldLeft(reversedList1, list2)((result, element) => Cons(element, result))
  }

  def appendLists[A](lists: List[List[A]]): List[A] = lists match {
    case Nil => Nil
    case Cons(head, tail) => foldLeft(tail, head)((result, list) => appendFoldLeft(result, list))
  }

  def init[A](list: List[A]): List[A] = {

    @tailrec
    def appendWhile(list: List[A], validatedList: List[A] = Nil): List[A] = list match {
      case Cons(head, tail) if tail != Nil => appendWhile(tail, append(validatedList, List(head)))
      case _ => validatedList
    }

    appendWhile(list)

  }

  def foldRight[A, B](list: List[A], result: B)(f: (A, B) => B): B = list match {
    case Nil => result
    case Cons(head, tail) => f(head, foldRight(tail, result)(f))
  }

  def sum2(list: List[Int]): Int =
    foldRight(list, 0)((x, y) => x + y)

  def product2(list: List[Double]): Double =
    foldRight(list, 1.0)(_ * _)

  def length[A](list: List[A]): Int = {
    foldRight(list, 0)((_, count) => count + 1)
  }

  @tailrec
  def foldLeft[A, B](list: List[A], result: B)(f: (B, A) => B): B = list match {
    case Nil => result
    case Cons(head, tail) => foldLeft(tail, f(result, head))(f)
  }

  def sumFoldLeft(list: List[Int]): Int =
    foldLeft(list, 0)(_ + _)

  def productFoldLeft(list: List[Double]): Double =
    foldLeft(list, 1.0)(_ * _)

  def lengthFoldLeft[A](list: List[A]): Int =
    foldLeft(list, 0: Int)((count, _) => count + 1)

  def reverse[A](list: List[A]): List[A] =
    foldLeft(list, Nil:List[A])((reversed, element) => Cons(element, reversed))

  def foldLeftByFoldRight[A, B](list: List[A], result: B)(f: (B, A) => B): B =
    foldRight(list, result)((a: A, b: B) => f(b,a))

  def foldRightByFoldLeft[A, B](list: List[A], result: B)(f: (A, B) => B): B =
    foldLeft(list, result)((b: B, a: A) => f(a,b))

  def increment(list: List[Int]): List[Int] = list match {
    case Nil => list
    case Cons(head, tail) => Cons(head + 1, increment(tail))
  }

  def doubleToString(list: List[Double]): List[String] = {
    val reversedList = reverse(list)
    foldLeft(reversedList, Nil:List[String])((strings, double) => Cons(double.toString, strings))
  }

  def map[A,B](list: List[A])(f: A => B): List[B] = {
    val reversedList = reverse(list)
    foldLeft(reversedList, Nil:List[B])((b: List[B], a: A) => Cons(f(a), b))
  }

  def filter[A](list: List[A])(f: A => Boolean): List[A] = {
    val reversedList = reverse(list)
    foldLeft(reversedList, Nil:List[A])((b: List[A], a: A) => if (f(a)) b else Cons(a, b))
  }

  def flatMap[A, B](list: List[A])(f: A => List[B]): List[B] = {

    val reversedList = reverse(list)
    val listOfLists = foldLeft(reversedList, Nil: List[List[B]])((b: List[List[B]], a: A) => Cons(f(a), b))

    appendLists(listOfLists)

  }

  def flatMapFilter[A](list: List[A])(f: A => Boolean): List[A] = {
    flatMap(list)( (a: A) => if (f(a)) List(a) else Nil)
  }

  def addLists(list1: List[Int], list2: List[Int]): List[Int] = {

    if (lengthFoldLeft(list1) != lengthFoldLeft(list2)) Nil
    else {
      val reversedList1 = reverse(list1)
      val reversedList2 = reverse(list2)

      foldLeft(reversedList2, (Nil: List[Int], reversedList1: List[Int])){ case ((list, list1), head2) => {
        list1 match {
          case Nil => (list, Nil)
          case Cons(head1, _) =>
            val zip = head1 + head2
            (Cons(zip, list), tail(list1))
        }
      }}
    }._1

  }

  def zipWith[A, B, C](list1: List[A], list2: List[B])(f: (A, B) => C): List[C] = {

    if (lengthFoldLeft(list1) != lengthFoldLeft(list2)) Nil
    else {
      val reversedList1 = reverse(list1)
      val reversedList2 = reverse(list2)

      foldLeft(reversedList2, (Nil: List[C], reversedList1: List[A])){ case ((list, list1), head2) => {
        list1 match {
          case Nil => (list, Nil)
          case Cons(head1, _) =>
            val zip = f(head1, head2)
            (Cons(zip, list), tail(list1))
        }
      }
    }}._1

  }

  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {

    @tailrec
    def compareElements(superSeq: List[A], subSeq: List[A]): Boolean = {

      subSeq match {
        case Nil => true
        case Cons(headSubSeq, tailSubSeq) =>
          superSeq match {
            case Nil => false
            case Cons(headSuperSeq, tailSuperSeq) =>
              if (headSuperSeq == headSubSeq) compareElements(tailSuperSeq, tailSubSeq)
              else compareElements(tailSuperSeq, sub)
          }
      }

    }

    compareElements(sup, sub)

  }

}
