/**

P01 (*) Find the last element of a list.
Example:
  scala> last(List(1, 1, 2, 3, 5, 8))
res0: Int = 8

  */


// last 함수는 while 문을 통해 마지막 하나의 element 가 남을 때 까지 반복하는 형식으로 구현되어 있다
// 이와 유사한 형식으로 last 함수를 구현하기 위해 재귀를 사용한다.
// recursive method 는 리턴 타입을 지정해 주어야 함
// error: recursive method last needs result type
// 어떤 타입이건 처리 가능하도록 하기 위해 타입변수 A 선언
def last[A](list: List[A]): A = {
  list match {
    case lastElement :: Nil => lastElement
    case _ :: tail => last(tail)
    case Nil => throw new Exception("list is empty")
  }

  list.last
}

// Nil : element 가 없는 List 를 의미
// 위에서 사용한 lastElement :: Nil 은 element가 한개인 list가 match된다.

last(List(1, 1, 2, 3, 5, 8, 11))