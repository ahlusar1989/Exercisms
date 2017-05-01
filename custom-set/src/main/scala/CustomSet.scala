import scala.annotation.tailrec


sealed trait CustomSet[+A]
case object Nil extends CustomSet[Nothing]
case class Cons[+A](head: A, tail: CustomSet[A]) extends CustomSet[A]

/**
  * Created by saranahluwalia on 5/1/17.
  */
object CustomSet {

  @tailrec
  def foldLeft[A,B](input: CustomSet[A], accumulator: B)(f: (B, A) => B): B =
    input match {
    case Nil => accumulator
    case Cons(begin, end) =>  foldLeft(end, f(accumulator, begin))(f)
  }

  def fromList[A](accumumulation: List[A]) = {
    accumumulation.foldLeft(Nil: CustomSet[A])((acc, e) => Cons(e, acc))
  }


def toList[A](s: CustomSet[A]): List[A] = {
  foldLeft(s, List[A]())((acc, ele) => ele :: acc)
}




}
