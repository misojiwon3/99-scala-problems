/**
P17 (*) Split a list into two parts.
The length of the first part is given. Use a Tuple for your result.
Example:

scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  */

// 이렇게 하면 쉽지만
def split[A](num: Int, list: List[A]) = {
  (list.take(num), list.drop(num))
}

split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

// 99 problems 는 recursive 를 좋아하니깐
def splitRecursive[A](num: Int, list: List[A]): (List[A], List[A]) = {
  (num, list) match {
    case (_, Nil) => (Nil, Nil)
    case (0, l) => (Nil, l)
    case (n, head :: tail) =>
      val (first, second) = splitRecursive(n - 1, tail)
      (head :: first, second)
  }
}

splitRecursive(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))


// Solution Tail recursive.
def splitTailRecursive[A](n: Int, ls: List[A]): (List[A], List[A]) = {
  def splitR(curN: Int, curL: List[A], pre: List[A]): (List[A], List[A]) =
    (curN, curL) match {
      case (_, Nil)       => (pre.reverse, Nil)
      case (0, list)      => (pre.reverse, list)
      case (n, h :: tail) => splitR(n - 1, tail, h :: pre)
    }
  splitR(n, ls, Nil)
}

splitTailRecursive(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

