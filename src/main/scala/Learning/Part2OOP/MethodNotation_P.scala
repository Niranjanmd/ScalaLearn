package Learning.Part2OOP


object MethodNotation_P extends App {

  class person(val name: String,favMovie:String,val age:Int=0) {

    def +(nickname: String): person = new person(s"${this.name}(${nickname})",favMovie) //this will return a new object

    def unary_+ = new person(this.name,this.favMovie,this.age + 1)

    def printAge = println(age)


    def learns(s: String) = s"${this.name} learns ${s}"

    def learnScala: String = learns("scala")

    def apply(): String = s"HI, my name is ${this.name} and my fav movie ${this.favMovie}"
    def apply(i:Int)=s"${this.name} won games ${i} times"

  }


  val mary = new person("mary","Inception")

  println((mary + "Rockstar")()) //apply method will be called
//  println((mary + "Rockstar").apply()) //apply method will be called

  println((+mary).age)

  +mary printAge

//  mary.unary_+.print

  println(mary learnScala)

  println(mary(10))


  //  println(t.age)
}
