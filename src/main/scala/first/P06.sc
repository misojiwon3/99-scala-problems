/**
P06 (*) Find out whether a list is a palindrome.
Example:
scala> isPalindrome(List(1, 2, 3, 2, 1))
res0: Boolean = true
  */


// builtin reverse 함수를 사용하면 간단한게 구현 가능
def isPalindrome[A](list: List[A]): Boolean = {
  list.reverse == list
}

isPalindrome(List(1, 2, 3, 2, 1))


// 이렇게 복잡하게 할 수도 있다
def isPalindrome2[A](list: List[A]): Boolean = {
  val limit = list.length / 2
  var l = list
  var symmetrical = List.empty[A]

  while(l.length > limit) {
    val h :: tail = l
    l = tail
    if (l.length > symmetrical.length)
      symmetrical = h :: symmetrical
  }

  l == symmetrical
}


isPalindrome2(List(1, 2, 3, 2, 1))