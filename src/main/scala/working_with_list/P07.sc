/**
P07 (**) Flatten a nested list structure.
Example:
scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
res0: List[Any] = List(1, 1, 2, 3, 5, 8)
  */

List(List(1, 2), List(3, 4)).flatten
List(List(1, 1), Some(2), List(3, List(5, 8))).flatten

// 처음엔 이렇게 생각했는데, 이건 여러 List를 만들어서 다시 붙이는, 똑같은 일을 반복하는 것 밖에 안됨
def flatten(list: List[Any]): List[Any] = {
  val resultList = List.empty[Any]

  list.flatMap {
    case l: List[_] => flatten(l)
    case h => List(h) ::: resultList
  }
}

flatten(List(List(1, 1), 2, List(4, List(2, 3)), List(3, List(5, 8))))

// list에 새로 추가하는게 의미가 없으므로 아래같이 변경
def flatten2(list: List[Any]): List[Any] = {
  list.flatMap {
    case l: List[_] => flatten2(l)
    case h => List(h)
  }
}

flatten2(List(List(1, 1), 2, List(4, List(2, 3)), List(3, List(5, 8))))

List(1, 2, 3, 4).flatMap {e =>
  List(e.toDouble)
}