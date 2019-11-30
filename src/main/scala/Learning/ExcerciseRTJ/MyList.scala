package Learning.ExcerciseRTJ

abstract class MyList {
  /*
  HEAD
  TAIL
  ADD
  isEmpty
  toString
   */

  def head: Int

  def tail: MyList

  def add(element: Int): MyList

  def isEmpty: Boolean

  def printList: String

  override def toString: String = "[" + printList + "]"
}

class Empty extends MyList {
  override def head: Int = ???

  override def tail: MyList = ???

  override def add(element: Int): MyList = ???

  override def isEmpty: Boolean = true

  override def printList: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  override def head: Int = h

  override def tail: MyList = t

  override def add(element: Int): MyList = new Cons(element, this)

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

  val list = new Cons(1, new Cons(2,new Cons(3,new Empty)))

  println(list.head)

  println(list.toString)

  val empty = new Empty

  empty.isEmpty
}