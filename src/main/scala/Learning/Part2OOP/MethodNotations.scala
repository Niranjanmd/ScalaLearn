package Learning.Part2OOP

object MethodNotations extends  App {

  //inside object as there is already a person class in OObasic
  class person(val name:String,favMovie:String){
    def likes(movie:String) = movie == favMovie

    def hangsoutwith(person: person,i:Int):String=s"${this.name} hangsout with ${person.name}"

    def -(p:person):String=s"${this.name} don't like ${p.name}"



    def unary_! = "You Bang"

    def isAlive : Boolean = true

    def apply(): String = s"HI, my name is ${this.name} and my fav movie ${this.favMovie}"


  }


  val mary = new person("Mary","Inception")

  println(mary.likes("Inception"))

  //INFIX NOTATION
  println(mary likes "Inception")

  println(mary likes "inc")

  val tom = new person("Tom","X-MEN")

  println(mary hangsoutwith(tom,3))

  println(mary - tom) // operators are not reserved in scala

  //PREFIX NOTATION
  val x = -1  //equivalent to 1.unary_-

  val y = 1.unary_-

  //unary only work with  - + ~ ! operator

  println(!mary) // calling unary method ! in person class

  //postfix notation
  
  mary isAlive
  
  //apply

  println(mary.apply())
  println(mary()) //when ever compiler see object used as function apply method of the object will be called




}
