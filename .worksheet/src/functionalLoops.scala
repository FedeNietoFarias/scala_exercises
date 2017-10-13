object functionalLoops {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(68); 
  println("Welcome to the Scala worksheet");$skip(42); 
  def abs(x: Int) = if (x >= 0) x else -x;System.out.println("""abs: (x: Int)Int""");$skip(64); 
  def improve(guess: Int, x: Int) =
    (guess + x / guess) / 2;System.out.println("""improve: (guess: Int, x: Int)Int""");$skip(78); 
  def isGoodEnough(guess: Int, x: Int) =
    abs((guess * guess) - x) < 0.001;System.out.println("""isGoodEnough: (guess: Int, x: Int)Boolean""");$skip(37); 

  def sqrt(x: Int) = sqrtIter(1, x);System.out.println("""sqrt: (x: Int)Int""");$skip(120); 
  def sqrtIter(guess: Int, x: Int): Int =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x);System.out.println("""sqrtIter: (guess: Int, x: Int)Int""");$skip(99); 

  def factorial(n: Int): Int =
    if (n ==
      0)
      1

    else factorial(n -
      1) * n;System.out.println("""factorial: (n: Int)Int""")}

}
