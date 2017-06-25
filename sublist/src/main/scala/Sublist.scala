/**
  * Created by saranahluwalia on 4/16/17.
  */

class Sublist {
  def sublist[A](l1: List[A], l2: List[A]): Sublist.SublistType =
    if (l2.containsSlice(l1))  Sublist.Superlist
    else if (l1.containsSlice(l2))  Sublist.Sublist
    else if (l1.equals(l2))  Sublist.Equal
    else Sublist.Unequal

}


object Sublist {
  sealed abstract class SublistType
  case object Equal extends SublistType
  case object Unequal extends SublistType
  case object Sublist extends SublistType
  case object Superlist extends SublistType

  def sublist[A](l1: List[A], l2: List[A]): SublistType =
    if (l2.containsSlice(l1))  Superlist
    else if (l1.containsSlice(l2))  Sublist
    else if (l1.equals(l2)) Equal
    else Unequal
}