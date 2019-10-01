/**

P02 (*) Find the last but one element of a list.
Example:
scala> penultimate(List(1, 1, 2, 3, 5, 8))
res0: Int = 5

  */

// P01에서 문제를 해결했던 것과 같이 builtin method를 사용하면 너무 쉽게 끝남
// 이를 recursive, pattern match 를 통해 구현 해보자

def penultimate[A](list: List[A]): A = {
  list match {
    case penultimateElement :: _ :: Nil => penultimateElement
    case _ :: tail => penultimate(tail)
    case Nil => throw new Exception("list has one element or is empty")
  }
}


penultimate(List(1, 1, 2, 3, 5, 8, 11, 13))

// 이렇게 해도 답이 충분히 나오지만, 해설을 보면 특정 순서와 리스트를 입력받아
// 해당 리스트 마지막 n 번째의 element 를 반환하는 방식도 구현되어 있다.
// 한번 구현해본다.

def lastNthRecursive[A](n: Int, list: List[A]): A = {
  def lastNthR[A](c: Int, resultList: List[A]): A = {
    resultList match {
      case l if n == c => l.head
      case _ :: tail => lastNthR(c - 1, tail)
      case _ => throw new Exception("unknown")
    }
  }

  if (list.length < n) {
    throw new IllegalArgumentException
  } else {
    lastNthR(list.length, list)
  }
}

lastNthRecursive(3, List(1, 1, 2, 3, 5, 8, 11, 13))