package Learning.Part2OOP

import Learning.Part2OOP

/*

Points to remember -

no class level functionality
COMPANION OBJECT how to use
APPLY METHOD -- factory method used to create the object taking the input parameters


 */

object Objects extends App{

  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY

  //COMPANION OBJECT
  object Person {

    //CLASS LEVEL FUNCTIONALITY THAT IS THE STATIC DATA IN JAVA OR C#

    val N_EYES = 2
    def Can_Fly:Boolean= false

    def apply(father: Person, mother: Person): Person = new Person()
  }

  class  Person{
    //INSTANCE LEVEL FUNCTIONALITY

    def printPersonEyes = println(Person.N_EYES)
  }


  //this all run under main method
  val niru = Person

  val adam = Person

  println(niranjan== adam)

  val abhi = new Person
  val niranjan = new Person

  abhi.printPersonEyes

  println(niranjan== abhi)

  val child = Person(niranjan,abhi)

  child.printPersonEyes




}
