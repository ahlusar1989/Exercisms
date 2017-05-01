/**
  * Created by saranahluwalia on 4/16/17.
  */
class Accumulate {
  def accumulate[T, U](op: (T) => U, input: List[T]): Seq[U] = {
    input.foldRight(Seq.empty[U])(((element, input ) => op(element) +: input))
  }
}
