object termsAndTypes {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(66); 
  println("Welcome to the Scala worksheet");$skip(4); val res$0 = 
  1;System.out.println("""res0: Int(1) = """ + $show(res$0));$skip(13); val res$1 = 
  1 + 2 == 3;System.out.println("""res1: Boolean = """ + $show(res$1));$skip(32); 
  println("Hello," ++ "Scala!");$skip(10); val res$2 = 
  (1+2)*3;System.out.println("""res2: Int = """ + $show(res$2));$skip(11); val res$3 = 
  1.to(10);System.out.println("""res3: scala.collection.immutable.Range.Inclusive = """ + $show(res$3));$skip(10); val res$4 = 
  1 to 10;System.out.println("""res4: scala.collection.immutable.Range.Inclusive = """ + $show(res$4));$skip(46); 
  println(("Hello," ++ "Scala!").toUpperCase);$skip(17); val res$5 = 
  16.toHexString;System.out.println("""res5: String = """ + $show(res$5));$skip(26); val res$6 = 
  (0 to 10). contains(10);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(29); val res$7 = 
  (0 until 10). contains(10);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(18); val res$8 = 
   "foo". drop(1);System.out.println("""res8: String = """ + $show(res$8));$skip(18); val res$9 = 
   "bar". take(2);System.out.println("""res9: String = """ + $show(res$9))}
}
