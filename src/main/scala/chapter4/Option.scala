package chapter4

sealed trait Option[+A] {

  def map[B](f: A => B): Option[B] = this match {
    case Some(value) => Some(f(value))
    case None => None
  }

  def flatMap[B](f: A => Option[B]): Option[B] = this map f getOrElse None

  def getOrElse[B >: A](default: => B): B = this match {
    case Some(value) => value
    case None => default
  }

  def orElse[B >: A](ob: => Option[B]): Option[B] = if (this == None) ob else this

  def filter(f: A => Boolean): Option[A] = if (this map f getOrElse false) this else None

}

case class Some[+A](get: A) extends Option[A]

case object None extends Option[Nothing]

object Option {

  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
    a.flatMap(aValue => b.flatMap(bValue => Some(f(aValue, bValue))))

}