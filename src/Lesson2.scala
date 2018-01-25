import scala.annotation.tailrec

object Lesson2 extends App {

  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    }
    sumF
  }

  /**
    * Implementation of sum range using tail-recursive
    */
  def sumTailRec(f: Int => Int)(a: Int, b: Int): Int = {
    @tailrec
    def loop(c: Int, acc: Int): Int = {
      if (c > b) acc
      else loop(c + 1, f(c) + acc)
    }
    loop(a, 0)
  }


  /**
    * Implement isSorted, which checks whether an Array[A] is sorted according to a given comparison function:
    */
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    if (as.length == 0 || as.length == 1) true
    else as.sliding(2).forall(p => {
      if (p.length == 2) ordered(p(0), p(1))
      else true
    })
  }

  def fun(a: Int)(b: Int): Int = {
    a * b
  }

  /**
    * Let’s look at another example, currying, which converts a function f of two arguments into a function of
    * one argument that partially applies f.
    */
  def curry[A,B,C](f: (A, B) => C): A => (B =>  C) = {
    def j(a: A)(b: B): C = {
      f(a, b)
    }
    j
  }

  override def main(args: Array[String]): Unit = {
    //println("sum range 1 to 4 " + sum(x => x)(1, 4))
    val partialFunction = curry[Int, Int, Int]((a, b) => a * b)(2)
    println(partialFunction(4))

  }
}
