/**
P23 (**) Extract a given number of randomly selected elements from a list.
Example:
scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
res0: List[Symbol] = List('e, 'd, 'a)
Hint: Use the solution to problem P20
  */

// P20 에서 썼던 removeAt 함수
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

def randomSelect[A](n: Int, ls: List[A]): List[A] =
  if (n <= 0) {
    Nil
  } else {
    val (rest, e) = removeAt((new util.Random).nextInt(ls.length), ls)
    e :: randomSelect(n - 1, rest)
  }

randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))

