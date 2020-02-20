package Learning.ExcerciseRTJ

abstract class MyList[+A] {
  /*
  HEAD
  TAIL
  ADD
  isEmpty
  toString
   */

  def head: A

  def tail: MyList[A]

  def add[B >: A](element: B): MyList[B]

  def isEmpty: Boolean

  def printList: String

  //  def Map[B](transformer: MyTransform[A,B]):MyList[B]

  def Map[B](transform: A => B): MyList[B]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

  def foreach(f: A => Unit): Unit

  def sort(f: (A, A) => Int): MyList[A]

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]

  override def toString: String = "[" + printList + "]"


}


/*
this can be changed directly
trait MyPredicate[-T]{
  def test[T](a:T):Boolean
}

trait MyTransform[-A,B] {
  def transform(element:A):B
}
*/
object Empty extends MyList[Nothing] {
  override def head: Nothing = ???

  override def tail: Nothing = ???

  override def add[B >: Nothing](element: B): MyList[B] = ???

  override def isEmpty: Boolean = true

  override def printList: String = ""

  override def Map[B](transformer: Nothing => B): MyList[B] = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  override def foreach(f: Nothing => Unit): Unit = Empty

  override def sort(f: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = Empty
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def isEmpty: Boolean = false

  def printList: String = {
    if (this.isEmpty) {
      "" + h
    }
    else {
      h + " " + t.printList
    }

  }

  override def Map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer.apply(h), t.Map(transformer))
  }

  override def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer.apply(h) ++ tail.flatMap(transformer)
  }

  override def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate.apply(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def ++[B >: A](list: MyList[B]): MyList[B] = {
    new Cons(head, t ++ list)
  }

  override def foreach(f: A => Unit): Unit = {
    f(head)
    tail.foreach(f)
  }


  override def sort(compare: (A, A) => Int): MyList[A] = {

    def insert(x: A, sortedTail: MyList[A]): MyList[A] = {
      if (sortedTail.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedTail.head) <= 0) new Cons(x, sortedTail)
      else new Cons(sortedTail.head, insert(x, sortedTail.tail))
    }

    val sortedTail = t.sort(compare) // this takes first the last one Cons(1,Cons(2,Cons(3,Empty)))


    insert(head, sortedTail)
  }

  override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("List do not hav the same length")
    else new Cons(zip(h, list.head), tail.zipWith(list.tail, zip))
  }
}


object TestList extends App {

  val list = new Cons("A", new Cons("B", new Cons("C", Empty)))

  val listOfInts = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfInts1 = new Cons(4, new Cons(5, new Cons(6, Empty)))
  val listOfInts2 = new Cons(4, new Cons(5, Empty))

  println(listOfInts.zipWith(listOfInts1, (x, y:Int) => x * y))

  println(listOfInts2.zipWith(listOfInts, (x, y:Int) => x * y))

  //  println(list.head)
  //
  //  println(list.toString)

  println(listOfInts)

  // println(listOfInts.filter(new MyPredicate[Int] {
  //   override def test[T](a: T): Boolean = a==2
  // }).toString)

  //  listOfInts.filter(new MyPredicate[Int] {
  //    override def test[T](a: T): Boolean = a ==12
  //  })
  //
  //  println(listOfInts.Map(new MyTransform[Int,Int] {
  //    override def transform(element: Int): Int = element * 2
  //  }))
  //
  //  println(listOfInts.flatMap(new MyTransform[Int,MyList[Int]] {
  //    override def transform(element: Int): MyList[Int] = new Cons[Int](element,new Cons[Int](element+1,Empty))
  //  }))
  //

  //  println(listOfInts.filter((v1: Int) => v1 == 1))
  //
  //  println(listOfInts.flatMap((x: Int) => new Cons[Int](x, Empty)))
  //
  //  println(listOfInts.Map((x: Int) => x + 1))

  listOfInts.sort((x, y) => y - x)


  //  println(listOfInts.flatMap((element: Int) => new Cons[Int](element, new Cons[Int](element + 1, Empty))))

  //  println(listOfInts.Map((element: Int) => element * 2))


}