/**
P10 (*) Run-length encoding of a list.
Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
Example:

scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
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

def encode[A](list: List[A]): List[(Int, A)] = {
  pack(list).map(e => (e.length, e.head))
}

encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


