package Learning.part3fp

object AnanomusFunc extends App {

  val adder = new ((Int) => Int) {
    override def apply(v1: Int): Int = v1 * 2
  }

  println(adder(10))

  val doubler: Int => Int = (x: Int) => x * 2

  println(doubler(5))

  //method takes 2 params, since types are defined in lhs in rhs no need to mention same (a:Int,b:Int)

  val add: (Int, Int) => Int = (a, b) => a + b

  val doSomeThing = () => println("hi")
  println(doSomeThing)
  //with brace
  val stringToInt = {
    (a: String) => a.toInt
  }


  //even more syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 //equal to x => x + 1

  val addTwoValues: (Int, Int) => Int = _ + _ // equal to (a: Int, b: Int) => a + b


}
