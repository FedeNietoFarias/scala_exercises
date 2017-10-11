object termsAndTypes {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  1                                               //> res0: Int(1) = 1
  1 + 2 == 3                                      //> res1: Boolean = true
  println("Hello," ++ "Scala!")                   //> Hello,Scala!
  (1+2)*3                                         //> res2: Int = 9
  1.to(10)                                        //> res3: scala.collection.immutable.Range.Inclusive = Range 1 to 10
  1 to 10                                         //> res4: scala.collection.immutable.Range.Inclusive = Range 1 to 10
  println(("Hello," ++ "Scala!").toUpperCase)     //> HELLO,SCALA!
  16.toHexString                                  //> res5: String = 10
  (0 to 10). contains(10)                         //> res6: Boolean = true
  (0 until 10). contains(10)                      //> res7: Boolean = false
   "foo". drop(1)                                 //> res8: String = oo
   "bar". take(2)                                 //> res9: String = ba
}