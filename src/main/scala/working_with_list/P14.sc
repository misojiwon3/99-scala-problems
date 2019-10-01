/**
P14 (*) Duplicate the elements of a list.
Example:
scala> duplicate(List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  */

// flatMap을 잘 써야 한다. flatten 의 기능과 잘 연관지어 생각해야 함
def duplicate[A](list: List[Symbol]): List[Symbol] = {
  list.flatMap(l => List(l, l))
}


duplicate(List('a, 'b, 'c, 'c, 'd))
