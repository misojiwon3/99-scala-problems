/**
P05 (*) Reverse a list.
Example:
scala> reverse(List(1, 1, 2, 3, 5, 8))
res0: List[Int] = List(8, 5, 3, 2, 1, 1)
  */


def reverse[A](list: List[A]): List[A] = {
  var reversed = List.empty[A]
  var l = list

  while(l.nonEmpty) {
    val head :: tail = l
    l = tail
    reversed = head :: reversed
  }

  reversed
}

reverse(List(1, 2, 3, 4, 5, 6, 7))


// reverse를 재귀 형식으로 구현
// 두 리스트를 붙일 때는 ++ or ::: 를 사용 (:: 는 리스트와 단일 element)
def recursiveReverse[A](list: List[A]): List[A] = {
  list match {
    case Nil => Nil
    case head :: tail => recursiveReverse(tail) ++ List(head)
  }
}

recursiveReverse(List(1, 3, 5, 6, 7, 8, 9))


/**

// 논외로 :+ 는 리스트의 메소드이며, param으로 입력받은 element를 리스트의 마지막에 append
// (추가로 이 메소드는 수행 시간이 오래 걸리므로 사용을 권장하지 않음)
List(1, 2, 3) :+ 7
// res2: List[Int] = List(1, 2, 3, 7)

// 기호를 반대로 뒤집으면, 다음과 같이 표현한다.
// + 기호 쪽에 append 되며, : 쪽에 해당하는 param 이 List가 되어야 한다.
3 +: List(0, 1, 2)
// res3: List[Int] = List(3, 0, 1, 2)

// param에 List를 넣을 경우 다음과 같은 결과를 출력한다
List(1, 2, 3) :+ List(7)
res4: List[Any] = List(1, 2, 3, List(7))

  */


// tail recursive
def reverseTailRecursive[A](ls: List[A]): List[A] = {
  def reverseR(result: List[A], curList: List[A]): List[A] = curList match {
    case Nil       => result
    case h :: tail => reverseR(h :: result, tail)
  }
  reverseR(Nil, ls)
}

reverseTailRecursive(List(1, 2, 3, 4))

// pure functional
def reverseFunctional[A](ls: List[A]): List[A] =
  ls.foldLeft(List[A]()) { (r, h) => h :: r }

reverseFunctional(List(1, 2, 3, 4))

