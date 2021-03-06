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

  def empty[A](s: CustomSet[A]): Boolean = s == Nil

  @tailrec
  def member[A](s: CustomSet[A], m: A): Boolean =
    s match {
      case Nil => false
      case Cons(elem, rest) => if (elem == m) true else member(rest, m)
    }

  def insert[A](s: CustomSet[A], itemOfInterest: A): CustomSet[A] = {
    if (member(s, itemOfInterest)) s else Cons(itemOfInterest, s)
  }

  def union[A](sA: CustomSet[A], sB: CustomSet[A]): CustomSet[A] = {
    foldLeft(sA, sB)((acc, current) => insert(acc, current))
  }

  def difference[A](s1: CustomSet[A], s2: CustomSet[A]): CustomSet[A] = {
    foldLeft(s1, Nil: CustomSet[A])((acc, a) => {
      if (member(s2, a)) acc else Cons(a, acc)
    })
  }

  @tailrec
  def isSubsetOf[A](setA: CustomSet[A], setB: CustomSet[A]): Boolean = setA match {
    case Nil => true
    case Cons(current, rest) => member(setB , current) && isSubsetOf(rest, setB)
  }

  @tailrec
  def isDisjointFrom[A](firstSet: CustomSet[A], secondSet: CustomSet[A]): Boolean =
    firstSet match {
      case Nil => true
      case Cons(mem, tail) => !member(secondSet, mem) && isDisjointFrom(tail, secondSet)
  }

  def isEqual[A](setA: CustomSet[A], setB: CustomSet[A]): Boolean =
    empty(difference(setA, setB)) && empty(difference(setB, setA))

  def intersection[A](set1: CustomSet[A], set2: CustomSet[A]): CustomSet[A] = {
    foldLeft(set1, Nil: CustomSet[A])((accmulation, a) => if (member(set2, a)) Cons(a, accmulation) else accmulation)
  }

}
