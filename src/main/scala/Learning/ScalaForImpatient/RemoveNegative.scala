package Learning.ScalaForImpatient

import Learning.ScalaForImpatient.RemoveNegative.array

import scala.collection.mutable.ArrayBuffer

object RemoveNegative extends App {

  val array =  ArrayBuffer(1,-200,2,-1,10,-20)

// val posArray =  array.filter(x=> x > 0)
//
//  for(i <- posArray) {
//    println(i)
//  }
//
//  val pos = for(i <- array if i > 0) yield i
//
//  pos.foreach(println(_))

  //first way
//  val positiveArray = removeAllButFirstNegative(array)

//  positiveArray.foreach(println(_))

  def removeAllButFirstNegative(array:ArrayBuffer[Int]) : ArrayBuffer[Int] ={

    var i:Int =0
    var firstNeg = true

    while (i< array.length){
      if(array(i)<0){
        if(firstNeg){
          firstNeg = false
          i+=1
        }else{
          array.remove(i)
        }
      }
      else i+=1
    }
    array

  }

 def removeAllButFirstNEgative2(array:ArrayBuffer[Int]): ArrayBuffer[Int] ={
   val index  = (for(i<-0 until array.length if array(i)<0) yield i ) drop(1)
//   val indextoRemove = index.drop(1)
   for(i <- index.reverse) array.remove(i)
   array
 }
  def removeAllButFirstNEgative3(array:ArrayBuffer[Int]): Array[Int] = {
    val indexToremove = (for(i<-0 until array.length if array(i)<0) yield i ) drop(1)

    (for(i<-0 until array.length if !indexToremove.contains(i)) yield array(i) ).toArray

//    array
  }

  removeAllButFirstNEgative3((array)) foreach(println(_))

//  array.foreach(println(_))





}
