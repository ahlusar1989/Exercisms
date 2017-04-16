
import scala.collection._

//foldRight associates to the right. I.e. elements will be accumulated in right-to-left order:
//
//  List(a,b,c).foldRight(z)(f) = f(a, f(b, f(c, z)))
//foldLeft associates to the left. I.e. an accumulator will be initialized and elements will be added to
// the accumulator in left-to-right order:
//
//  List(a,b,c).foldLeft(z)(f) = f(f(f(z, a), b), c)



object Strain {
    def keep[T](xs: Seq[T], predicateFunc: T => Boolean): Seq[T] = {
      xs.foldRight(Seq.empty[T]) {
        case (current, rest) => if (predicateFunc(current)) current +: rest else rest
      }
    }

    def discard[T](ls: Seq[T], f: T => Boolean): Seq[T] = {
        keep[T](ls, !f(_))
    }
}