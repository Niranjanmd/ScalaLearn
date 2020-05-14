package Learning.part3fp

/*
A Function which takes another function as parameter is called as higher order Function

function that applies a fuction n number of times over a value x
nTimes(f,n,x)

nTimes(f,5,x) =>  f(f(f(x)))

nTimes(f,5,f(1)) //f(1) is two so 2 is passed ad x in second iteration
nTimes(f,4,f(2)) //f(2) is 3
nTimes(f,3,f(3)) //f(3) is 4
nTimes(f,2,f(4)) //f(4) is 5
nTimes(f,1,f(5)) //f(4) is 6
now n will be 0 and hence  6 will be return as output


 */
object HOFsCurries extends App {

  //  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int, Int) = ???


  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else
      nTimes(f, n - 1, f(x))
  }

  val Incrementer: Int => Int = _ + 1

  val res = nTimes(Incrementer, 5, 1)

  println(res)

  def nTimesBetter(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0)
      (x: Int) => x
    else
      (x: Int) => nTimesBetter(f, n - 1)(f(x)) //apply
  }


  val incr10 = nTimesBetter((x: Int) => x + 1, 10)

  println(incr10(1))


  //Curried Function

  def specialFun(x: Int): (Int => Int) = {


    //this is curried
    def inner(y: Int): Int = {
      x + y
    }

    inner

    //        y => x + y //this is equivalent to inner method

  }

  val test = specialFun(3)
  println("test " + test(10))

  val specialFunction: Int => (Int => Int) = x => y => x + y // here x is the input for outer function and y is input for inner function

  val adder = specialFunction(23) // 23 is x

  println(adder(3))  //3 is y

  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val StandardFormat: (Double => String) = curriedFormatter("%4.2f")
  val precisionFormat: (Double => String) = curriedFormatter("%10.8f")

  println(curriedFormatter("%3.3f")(Math.PI))

  println(StandardFormat(Math.PI))
  println(precisionFormat(Math.PI))


  def toCurry[A](fun: (A, A) => A): (A => A => A) = x => y => fun(x, y)

  //    x => y => fun(x, y)

  val superAdder: (Int => (Int => Int)) = toCurry((x, y) => x + y)

  val add4 = superAdder(4)
  println(add4(20))


}

