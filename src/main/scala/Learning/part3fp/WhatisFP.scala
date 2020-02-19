package Learning.part3fp

object WhatisFP extends App {

  val addString = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  //alternative
  //  val addStringFp = new ((String, String) => String){
  //    override def apply(v1: String,v2:String): String = v1 + v2
  //  }

  println(addString("a", "b"))

  //
  //  val specialFunction:(Int) => ((Int) => Int) = new ((Int) => Function1[Int, Int]) {
  //    override def apply(x: Int): Int => Int = new Function[Int,Int] {
  //      override def apply(y: Int): Int = x + y
  //    }
  //  }

  //short hand
  val specialFunction: Int => (Int => Int) = x => y => x + y

  val adder = specialFunction(23)

  println(adder(3))

  println(specialFunction(2)(3))

  val superAdder = (x: Int) => (y: Int) => x + y


}
