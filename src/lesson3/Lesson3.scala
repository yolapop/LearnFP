package lesson3

object Lesson3 {

  /**
    * Another way to create List implementations
    */
  trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
  }

  /**
    * Construct
    * @param head This will implement super.head
    * @param tail This will implement super.tail
    * @tparam T
    */
  class Const[T](val head: T, val tail: List[T]) extends List[T] {
    override def isEmpty: Boolean = false
  }

  class Nil extends List[Nothing] {
    override def isEmpty: Boolean = true

    /**
      * Throw statement will return Nothing, we could make it explicit
      * @return
      */
    override def head: Nothing = throw new NoSuchElementException("Nil.head")

    /**
      * If you notice, this method returns Nothing, that's because Nothing is
      * a subtype of everything, including List[T]
      * @return
      */
    override def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  }

  abstract class IntSet {
    def incl(x: Int): IntSet
    def contains(x: Int): Boolean
  }

  class Empty extends IntSet {
    override def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

    override def contains(x: Int): Boolean = false
  }

  class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
    def contains(x: Int): Boolean =
      if (x < elem) left contains x
      else if (x > elem) right contains x
      else true
    def incl(x: Int): IntSet =
      if (x < elem) new NonEmpty(elem, left incl x, right)
      else if (x > elem) new NonEmpty(elem, left, right incl x)
      else this
  }

  /*def tryArray(): Unit = {
    val a: Array[NonEmpty] = Array(new NonEmpty(1, new Empty, new Empty))
    val b: Array[IntSet] = a
    b(0) = Empty
    val s: NonEmpty = a(0)
  }*/

  def something(x: Int): Int = x

  def passSomething(f: (Int) => Int): Unit = {
    print(f(2))
  }

  def main(args: Array[String]): Unit = {
    passSomething(something)
  }

}
