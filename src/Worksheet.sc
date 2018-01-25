def listOfDuplicates[A](x: A, length: Int): List[A] = {
  if (length < 1)
    Nil
  else
    x :: listOfDuplicates(x, length - 1)
}
listOfDuplicates[Int](3, 4)
listOfDuplicates("La", 8)

import Lesson2._

// define sumId dan sumCube di sini pakai method sum
// consecutive stepwise application

def partialFunction = curry[Int, Int, Int]((a, b) => a * b)(2)
partialFunction(4)

isSorted(Array(1, 2, 3, 4), (a: Int, b: Int) => a < b)

def f: (Int) => Int = fun(2)
f(4)

val sum: (Int, Int) => Int = sumTailRec(x => x)