object functionalLoops {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def abs(x: Int) = if (x >= 0) x else -x         //> abs: (x: Int)Int
  def improve(guess: Int, x: Int) =
    (guess + x / guess) / 2                       //> improve: (guess: Int, x: Int)Int
  def isGoodEnough(guess: Int, x: Int) =
    abs((guess * guess) - x) < 0.001              //> isGoodEnough: (guess: Int, x: Int)Boolean

  def sqrt(x: Int) = sqrtIter(1, x)               //> sqrt: (x: Int)Int
  def sqrtIter(guess: Int, x: Int): Int =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)           //> sqrtIter: (guess: Int, x: Int)Int

  def factorial(n: Int): Int =
    if (n ==
      0)
      1

    else factorial(n -
      1) * n                                      //> factorial: (n: Int)Int

}