package Learning.Part2OOP


/*

Access modifiers
Private only with in class
public any one can access
protected can be accessed only inside the child class

Constructor - auxiliary constructor

OVERRIDING - scala allow to override VALUES(VAL), VARIABLES(VARS) and FUNCTIONS(DEF)

PREVENT OVERRIDE
using keyword final on member
using keyword final on class( AVOID IT FROM EXTEND )
using seal classed = we can extend the class in same file and not allow to extend it in other files
 */
object InheritanceAndTraits extends App{

  class Animal{
    def eat = println("eat eat ")

    protected  def dance = println("do dance ")
  }


  class Cat extends Animal{

    def activites = {
      dance                    //Can ACCESS PROTECTED MEMBER OF PARENT
      println("cat walk")
    }
  }

  //OVERRIDING
  class Dog extends Animal{
    override def eat: Unit = println("DOG EATING")
  }

  val doggy = new Dog

  doggy.eat

  val caty = new Cat

  caty.eat //Public Can be accessed by any one
//  caty.dance //not allowed as it is protectd
  caty.activites //



  //////CONSTRUCTOR

  class Person(name:String ,  age :Int){
    def this(name:String) =   this(name,0)
  }

  class Adult(name :String,age:Int,idCard :String) extends Person(name ,age)  // parent class has to Constructed before child

  class Minor(name :String,age:Int) extends Person(name)  // this is possible by using auxiliary constructor

}
