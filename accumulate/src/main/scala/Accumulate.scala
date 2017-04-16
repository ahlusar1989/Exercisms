/**
  * Created by saranahluwalia on 4/16/17.
  */
class Accumulate {
  def accumulate[T, U](op: (T) => U, input: Seq[T]): Seq[U] = {
    input.map(x => op(x))
  }
}
