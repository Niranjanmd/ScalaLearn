package Learning.ExcerciseRTJ

trait MyList[A] {
  /*
  HEAD
  TAIL
  ADD
  isEmpty
  toString
   */

  def head: A

  def tail: MyList[A]

  def add(element: A): MyList[A]

  def isEmpty: Boolean

  def printList: String

  override def toString: String = "[" + printList + "]"
}

class Empty[A] extends MyList[A] {
  override def head: A = ???

  override def tail: MyList[A] = ???

  override def add(element: A): MyList[A] = ???

  override def isEmpty: Boolean = true

  override def printList: String = ""
}

class Cons[A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def add(element: A): MyList[A] = new Cons(element, this)

  override def isEmpty: Boolean = false

  def printList:String ={
    if(this.isEmpty){
      "" + h
    }
    else {
      h + " "+ t.printList
    }

  }
}

object TestList extends App {

  val list = new Cons("A", new Cons("B",new Cons("C",new Empty)))

  println(list.head)

  println(list.toString)

  val empty = new Empty

  empty.isEmpty
}