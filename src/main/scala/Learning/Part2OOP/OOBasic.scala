package Learning.Part2OOP

import sun.plugin.dom.css.Counter

object OOBasic extends App {

  //instantiation
  //  val person = new Person("Niranjan", 28)

  //  println(person.age)
  //  person.greet("New user")
  //  person.greet()

  val author = new Writer("Charls", "Dikens", 1990)

  val another_author = new Writer("jack", "daniel", 1884)

  val novel = new Novel("Maha", 2011, author)

  println(s"Name of Author ${novel.WritterBy}")

  println(s"Author age when book relesed ${novel.AuthorAge}")

  println(novel.isWritterBy(author))

  println(novel.isWritterBy(another_author))

  val counter = new counter

  counter.inc.print
  counter.inc(5).print
//  counter.inc.print
  counter.dec(2).print
//  counter.dec.print

}

//below name is class parameter and age is class Field if we add val/var to parameter it become field
class Person(name: String, val age: Int) { //constructor

  //body
  val x = 2

  def greet(name: String) = println(s"${this.name} says hi to ${name}")

  def greet() = println(s"hi!! I am ${name}")
}

class Novel(name: String, releaseDate: Int, author: Writer) {
  def AuthorAge: Int = releaseDate - author.dob

  def WritterBy: String = author.FullName

  def isWritterBy(author: Writer) = this.author == author


  def copy(newYear: Int): Novel = new Novel(this.name, newYear, this.author)

}

class Writer(fName: String, lName: String, val dob: Int) {
  def FullName: String = s"${fName} ${lName}"

  //  val bi = age

}


class counter(val i: Int = 0) {

  def inc ={
    println("Incrementing")
    new counter(i + 1)
  }

  def dec = {
    println("Decrementing")

    new counter(i - 1)
  }

//  def inc(c: Int) = new counter(i + c)
//
//  def dec(c: Int) = new counter(i - c)

  def inc(count:Int):counter= {
    if (count<=0) this
    else
    inc.inc(count-1)
  }


  def dec(count:Int):counter={
    if(count<=0) this
    else
      dec.dec(count-1)
  }

  def print = println(i)
}
