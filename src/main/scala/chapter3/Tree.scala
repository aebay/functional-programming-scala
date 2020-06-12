package chapter3

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  def size[A](tree: Tree[A]): Int = tree match {
    case Leaf(_) => 1
    case Branch(left, right) => size(left) + size(right) + 1
  }

  def maximum(tree: Tree[Int]): Int = tree match {
    case Leaf(value) => value
    case Branch(left, right) => maximum(left) max maximum(right)
  }

  def depth[A](tree: Tree[A]): Int = tree match {
    case Leaf(_) => 1
    case Branch(left, right) => (depth(left) max depth(right)) + 1
  }

  def map[A, B](tree: Tree[A])(f: A => B): Tree[B] = tree match {
    case Leaf(value) => Leaf(f(value))
    case Branch(left, right) => Branch(map(left)(f), map(right)(f))
  }

  def fold[A, B](tree: Tree[A])(f: A => B)(g: (B, B) => B): B = tree match {
    case Leaf(value) => f(value)
    case Branch(left, right) => g(fold(left)(f)(g), fold(right)(f)(g))
  }

  def foldSize[A](tree: Tree[A]): Int = {
    fold(tree)(_ => 1)((left: Int, right: Int) => left + right + 1)
  }

  def foldMaximum(tree: Tree[Int]): Int = {
    fold(tree)(value => value)((left: Int, right: Int) => left max right)
  }

  def foldDepth[A](tree: Tree[A]): Int = {
    fold(tree)(_ => 1)((left: Int, right: Int) => (left max right) + 1)
  }

  def foldMap[A, B](tree: Tree[A])(f: A => B): Tree[B] = {
    fold(tree)(value => Leaf(f(value)): Tree[B])((left: Tree[B], right: Tree[B]) => Branch(left, right))
  }

}
