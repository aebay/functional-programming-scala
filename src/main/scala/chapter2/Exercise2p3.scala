package chapter2

object Exercise2p3 {

  def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
    (a: A) => ((b: B) => f(a,b))
  }

}