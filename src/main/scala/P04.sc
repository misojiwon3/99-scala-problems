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