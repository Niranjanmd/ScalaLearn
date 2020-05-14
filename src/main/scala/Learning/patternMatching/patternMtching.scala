package Learning.patternMatching

import jdk.nashorn.internal.ir.LiteralNode.PrimitiveLiteralNode

import scala.util.Random

object patternMtching extends App {


  val number = Random.nextInt(10)

  val description = number match {
    case 1 => "Number one"
    case 2 => "Double Treat"
    case 3 => "third the last"
    case _ => "something else"
  }

  println(description)

  case class Person(name: String, age: Int)

  val bob = Person("Bob", 24)

  val greeting = bob match {
    case Person(n, a) => s"hi my name is ${n} and my age is ${a}"
    case _ => "dont know who i am"
  }

  println(greeting)


  /*
  excercise
   */

  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr

  case class Product(e1: Expr, e2: Expr) extends Expr


  def showNumber(e: Expr): String = {
    e match {
      case Number(n) => s"$n"
      case Sum(a, b) => showNumber(a) + " + " + showNumber(b)
      case Product(a, b) =>{
        def maybeshowparnathasis(exp:Expr) ={
          exp match {
            case Product(_,_)=>showNumber(exp)
            case Number(_)=>showNumber(exp)
            case _ => "(" + showNumber(exp) + ")"
          }
        }
        maybeshowparnathasis(a) + " * " + maybeshowparnathasis(b)
      }
      case _ => "not found"
    }
  }


  println(showNumber(Sum(Sum(Number(1), Number(2)), Number(2))))
  println(showNumber(Product(Sum(Number(1),Number(2)),Number(3))))

}
