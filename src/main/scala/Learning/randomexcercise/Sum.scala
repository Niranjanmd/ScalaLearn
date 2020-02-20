package Learning.randomexcercise

object Sum extends App {


  def sumBetweenNumber(a: Int, b: Int): Int = {

    val range = a.to(b)

    range.sum


  }

  println(sumBetweenNumber(1, 10))

  def SumBetweenFP(a: Int, b: Int): Int = {
    if (a >= b) a
    else
      a + SumBetweenFP(a + 1, b)
  }

  /*
    SumBetweenFP(1,10)
   */

  println(SumBetweenFP(1, 10))


  def SumOFCubeBetweenNumber(a: Int, b: Int): Int = {
    var sum = 0

    for (i <- a to b) {
      sum = sum + (i * i * i)
    }

    sum

  }


  println(SumOFCubeBetweenNumber(1, 3))


  def SumOFCubeBetweenNumberFP(a: Int, b: Int): Int = {
    if (a >= b) cubeof(a)
    else
      cubeof(a) + SumOFCubeBetweenNumberFP(a + 1, b)
  }

  def cubeof(n: Int): Int = {
    n * n * n
  }


  println(SumOFCubeBetweenNumberFP(1, 3))

  /*
  Changing to Higher order function
   */

  def sumBetweenNumHOF(f: (Int => Int), a: Int, b: Int): Int = {
    if (a > b) 0
    else
      f(a) + sumBetweenNumHOF(f, a + 1, b)
  }

  println("Cube from HOF " + sumBetweenNumHOF(cubeof, 1, 3))


  def computeBetweenNumber(f: (Int => Int), a: Int, b: Int): Int = {
    if (a > b) 0
    else {
      println(s"fact of ${a} = " + f(a))
      f(a) + computeBetweenNumber(f, a + 1, b)
    }
  }


  val cube = (x: Int) => x * x * x

  val id = (x: Int) => x

  val fact: (Int => Int) = (x: Int) => if (x == 0) 1 else x * fact(x - 1)

  println(fact(2))


  println("fact between Number HOF " + computeBetweenNumber(fact, 1, 5))

  //  println("cube Between Number HOF " + computeBetweenNumber(cube,1,3))


  for( i <- 1 to 10 )
    println("hi")
}
