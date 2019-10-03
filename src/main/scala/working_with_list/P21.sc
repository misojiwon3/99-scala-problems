/**
P21 (*) Insert an element at a given position into a list.
Example:
scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
  */

def insertAt[A](e: A, n: Int, ls: List[A]): List[A] = {
  ls.splitAt(n) match {
    case (pre, post) => pre ::: e :: post
  }
}

def insertAt2[A](value: A, index: Int, list: List[A]) = {
  def recursiveInsertAt[A](nn: Int, l: List[A]): List[A] = {
    (nn, l) match {
      case (_, Nil) => Nil
      case (0, li) => li.appended(value)
      case (n, head :: tail) => head :: recursiveInsertAt(n - 1, tail)
    }
  }

  if (index < 0 || index > list.length) {
    throw new Exception
  } else {
    recursiveInsertAt(index, list)
  }
}

insertAt2('new, 1, List('a, 'b, 'c, 'd))