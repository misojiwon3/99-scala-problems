/**
P22 (*) Create a list containing all integers within a given range.
Example:
scala> range(4, 9)
res0: List[Int] = List(4, 5, 6, 7, 8, 9)
  */

def range(start: Int, end: Int): List[Int] = {
  if (start > end) {
      Nil
  } else {
    start :: range(start + 1, end)
  }
}

range(4, 9)


// Builtin.
def rangeBuiltin(start: Int, end: Int): List[Int] = {
  List.range(start, end + 1)
}

rangeBuiltin(4, 9)