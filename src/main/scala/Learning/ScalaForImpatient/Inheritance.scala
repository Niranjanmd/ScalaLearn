package Learning.ScalaForImpatient

object Inheritance extends  App {

  class Animal {
    val Type = "Herbi"
    val lifeSpan:Int = 100
  }

  class dog extends Animal{

    override val lifeSpan: Int = 15

    def getLifeSpan = lifeSpan



  }


  class cat extends Animal{
    override val lifeSpan: Int = 10

    def getLifeSpan = lifeSpan
  }

  class Trainer[+A]


  val animal:Animal = new cat

  val c1:Trainer[Animal] = new Trainer[cat]


}
