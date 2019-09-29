/**
P19 (**) Rotate a list N places to the left.
Examples:
scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
  */

def rotate[A](num: Int, list: List[A]) = {
  num match {
    case 0 => list
    case n: Int if n > 0 =>
      list.drop(n) ::: list.take(n)
    case n: Int if n < 0 =>
      list.drop(list.length + n) ::: list.take(list.length + n)
  }
}

rotate(-3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))