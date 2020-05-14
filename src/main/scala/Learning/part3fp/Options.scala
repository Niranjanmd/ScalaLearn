package Learning.part3fp

import java.util.Random

/*
option is a wrapper for a value that might be present or not
options are used to avoid he null pointer exceptions
 */

object Options extends App {

  val someVal: Option[Int] = Some(4)

  val otherVal: Option[Int] = None


  println(someVal)

  println(otherVal)

  def unsafeFunction: String = null

  //  val result = Some(unsafeFunction)  // never do this //WRONG way

  val result = Option(unsafeFunction) //result will be  Some or None

  println(result)


  //  chained methods

  def backupMethod: String = {
    "A String"
  }


  val res = Option(unsafeFunction) orElse Option(backupMethod) // user has to use the option here


  def betterUnsafeMethod: Option[String] = null

  def betterBackupMethod: Option[String] = Some("Some result String")

  val res_better = betterBackupMethod orElse betterBackupMethod // this is better usage of the

  println(res_better)


  val config: Map[String, String] = Map(
    "host" -> "123.1.2.4",
    "port" -> "80"
  )


  class Connection {
    def connect: String = "Connected "
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if ( random.nextBoolean()) Some(new Connection())
      else None
    }
  }


  config.get("host").foreach(println(_))


}
