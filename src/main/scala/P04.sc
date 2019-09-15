/**
P04 (*) Find the number of elements of a list.
Example:
scala> length(List(1, 1, 2, 3, 5, 8))
res0: Int = 6
  */


def length[A](list: List[A]): Int = {
  var len = 0
  var l = list

  // head 를 제외 시킬 때 마다 count 를 1 증가시키며 length 를 측정
  while (l.nonEmpty) {
    len += 1
    l = l.tail
  }

  len
}


length(List(1, 2, 3, 4))


// Solution 에서 제공한 조금 더 함수형스러운 해결 방안
// fold에 대해서도 정리 할 필요가 있다
def lengthFunctional[A](ls: List[A]): Int = ls.foldLeft(0) { (c, _) => c + 1 }

lengthFunctional(List(1, 2, 3, 4))

