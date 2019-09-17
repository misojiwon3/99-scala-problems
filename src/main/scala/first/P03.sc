/**
P03 (*) Find the Kth element of a list.
By convention, the first element in the list is element 0.
Example:

  scala> nth(2, List(1, 1, 2, 3, 5, 8))
res0: Int = 2
  */

def nth[A](n: Int, list: List[A]): A = {
  // drop 을 구현하기 위해 아래 메소드 구현
  def removeHead(nn: Int, l: List[A]): List[A] = {
    if (nn <= 0 || l.isEmpty) {
      l
    } else {
      removeHead(nn - 1, l.tail)
    }
  }

  if (list.length <= n) {
    throw new Exception("list is shorter than n")
  } else {
    removeHead(n - 1, list.tail).head
  }
}

nth(4, List(1, 1, 2, 3, 5, 8))