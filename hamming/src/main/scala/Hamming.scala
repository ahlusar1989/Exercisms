/**
  */

object Hamming {

  def compute(s1: String, s2: String): Option[Int] =  {
    if(s1.length() != s2.length())
      return None
    if (s1.isEmpty() && s2.isEmpty()) {
      return Some(0)
    } else Some(s1.zip(s2).count {
        case (char1, char2) => char1 != char2
      })
    }
  }
