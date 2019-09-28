/**
P16 (**) Drop every Nth element from a list.
Example:
scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  */

def drop[A](n: Int, list: List[Symbol]) = {
  list.grouped(n).toList.flatMap { l =>
    l.take(n-1)
  }
}

drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))


def drop2[A](n: Int, list: List[Symbol]) = {
  list.zipWithIndex.filter { ll =>
    (ll._2 + 1) % n != 0
  }.map(_._1)
}

drop2(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

// solution
def dropRecursive[A](n: Int, ls: List[A]): List[A] = {
  def dropR(c: Int, curList: List[A]): List[A] = (c, curList) match {
    case (_, Nil)       => Nil
    case (1, _ :: tail) => dropR(n, tail)
    case (_, h :: tail) => h :: dropR(c - 1, tail)
  }
  dropR(n, ls)
}

dropRecursive(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))


/** 추가 사항 */
// grouped : list를 n개씩 묶음
val l = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

l.grouped(3).toList
// res3: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9), List(10))

// take : head 부터 n 개만큼 추출
l.take(4)
// res4: List[Int] = List(1, 2, 3, 4)

