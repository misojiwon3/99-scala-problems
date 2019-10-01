/**
P12 (**) Decode a run-length encoded list.
Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
Example:

scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  */

def decode[A](list: List[(Int, Symbol)]): List[Symbol] = {
  list.flatMap { l =>
    List.fill(l._1)(l._2)
  }
}


decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))


/** 추가 사항 */
// fill : 특정 수 많큼 elements 를 추가하여 리스트를 생성하는 방법
// List.fill(n)(element) : n개의 element 를 가진 리스트를 생성