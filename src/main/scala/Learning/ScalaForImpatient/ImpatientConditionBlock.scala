package Learning.ScalaForImpatient

object ImpatientConditionBlock extends  App {


  def isVowel(c:Char):Boolean={
    "aeiou".contains(c)
  }

  println (isVowel('e'))

  def Vowel(s:String):String={
    var ch = ""

    for(c<- s){
      if (isVowel(c))
        ch+=c
    }

    ch
  }

  println(Vowel("afoiaefpiavzkjnjkaFLSDJIEQEJFOs"))


  def Vowel2(input:String)={
    for(c<-input if isVowel(c)) yield c
  }

  println(Vowel2("xdafitzz"))

}
