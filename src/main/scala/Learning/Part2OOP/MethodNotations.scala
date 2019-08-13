package Learning.Part2OOP

object MethodNotations extends  App {

  class person(val name:String,favMovie:String){
    def likes(movie:String) = movie == favMovie
  }


  val mary = new person("Mary","Inception")

  println(mary.likes("Inception"))

  println(mary likes "Inception")
}
