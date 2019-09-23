/**
P11 (*) Modified run-length encoding.
Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
Example:

scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
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

def encodeModified[A](list: List[A]): List[Any] = {
  pack(list).map { e =>
    if (e.length == 1) {
      e.head
    } else {
      (e.length, e.head)
    }
  }
}

encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


