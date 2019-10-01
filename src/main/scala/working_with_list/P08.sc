/**
P08 (**) Eliminate consecutive duplicates of list elements.
If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
Example:

scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
  */

def compress(list: List[Symbol]): List[Symbol] = {
  var current: Symbol = null
  var l = List.empty[Symbol]

  list.foreach { e =>
    if (current != e) {
      current = e
      l = l ::: List(e)
    }
  }

  l
}

compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


// Solution 을 보니 dropWhile 이라는 메소드를 사용하였다.
def compressRecursive(list: List[Symbol]): List[Symbol] = {
  list match {
    case Nil => Nil
    case head :: tail => head :: compressRecursive(tail.dropWhile(_ == head))
  }
}

compressRecursive(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


// Functional.
def compressFunctional[A](ls: List[A]): List[A] =
  ls.foldRight(List[A]()) { (h, r) =>
    if (r.isEmpty || r.head != h) h :: r
    else r
  }

compressFunctional(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


/** 추가 정리 */
val list = List(1, 2, 3, 7, 4, 5, 6, 7, 8, 9, 10)

// 맨 앞 n개의 element 를 제거
list.drop(5)
// 맨 뒤 n개의 element 를 제거
list.dropRight(3)
// 맨 앞부터 구문의 결과가 true 인 모든 element 제거
list.dropWhile(_ < 5)
