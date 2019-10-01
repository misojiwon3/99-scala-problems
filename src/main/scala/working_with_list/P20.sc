/**
P20 (*) Remove the Kth element from a list.
Return the list and the removed element in a Tuple. Elements are numbered from 0.
Example:

scala> removeAt(1, List('a, 'b, 'c, 'd))
res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
  */

// recursive
def removeAt[A](num: Int, list: List[A]) = {
  def recursiveRemoveAt[A](nn: Int, l: List[A]): List[A] = {
    (nn, l) match {
      case (_, Nil) => Nil
      case (0, _ :: tail) => tail
      case (n, head :: tail) => head :: recursiveRemoveAt(n - 1, tail)
    }
  }

  if (num < 0 || num > list.length) {
    throw new Exception
  } else {
    (recursiveRemoveAt(num, list), list(num))
  }
}

removeAt(2, List('a, 'b, 'c, 'd))

// solution
def removeAt2[A](n: Int, ls: List[A]): (List[A], A) = {
  ls.splitAt(n) match {
    case (Nil, _) if n < 0 => throw new NoSuchElementException
    case (pre, e :: post)  => (pre ::: post, e)
    case (pre, Nil)        => throw new NoSuchElementException
  }
}

removeAt2(2, List('a, 'b, 'c, 'd))


/** 추가 사항 */
val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
// n개 + 나머지 리스트로 나눔
list.splitAt(3)
// res2: (List[Int], List[Int]) = (List(1, 2, 3),List(4, 5, 6, 7, 8, 9))