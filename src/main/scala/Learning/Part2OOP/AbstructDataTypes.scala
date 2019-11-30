package Learning.Part2OOP

/*
Traits - similar to interface but this allows default implementation of methods
Abstract Class - Same as OOPS



 */

object AbstructDataTypes extends  App {

  abstract  class Animal{
    val CreatureType:String

    def eat:Unit
  }

  class Cat extends Animal{
    override val CreatureType: String = "Pet"

    override def eat: Unit = println("cat eating logic")
  }


  trait Carnivor{
    def eat:Unit

  }




  class Crocodile extends Animal with Carnivor{
    override val CreatureType: String = "Wild"

     def eat: Unit = println("CROC EAT MEAT")
  }


  val croc:Carnivor = new Crocodile

  val ca = new Cat

  croc.eat

  ca eat



}
