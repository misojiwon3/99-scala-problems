/**
P09 (**) Pack consecutive duplicates of list elements into sublists.
If a list contains repeated elements they should be placed in separate sublists.
Example:

scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  */

def pack[A](list: List[A]): List[List[A]] = {
  if (list.isEmpty) {
    List(List.empty[A])
  } else {
    val (packed, next) = list.span(_ == list.head)

    next match {
      case Nil => List(packed)
      case _ => packed :: pack(next)
    }
  }
}

pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


/** 추가 사항 */

// span 은 해당 조건에 해당하는 element들의 list와 나머지 list를 tuple로 반환
List(1, 2, 3, 4, 5).span(_ < 4)
// res1: (List[Int], List[Int]) = (List(1, 2, 3),List(4, 5))