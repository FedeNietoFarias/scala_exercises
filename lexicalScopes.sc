object lexicalScopes {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def square(x: Double) = x * x                   //> square: (x: Double)Double
  def sqrt(x: Double) = {
    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    def improve(guess: Double, x: Double) =
      (guess + x / guess) / 2

    def isGoodEnough(guess: Double, x: Double) =
      ((square(guess)) - x) < 0.001
    sqrtIter(1.0, x)
  }                                               //> sqrt: (x: Double)Double

  val x = 0                                       //> x  : Int = 0
  def f(y: Int) = y + 1                           //> f: (y: Int)Int
  val result = {
    val x = f(3)
    x * x
  } + x                                           //> result  : Int = 16
  //Da 16 porque la x toma el valor de 4 dentro del bloque (3+1) ,
  //y fuera del bloque es 0, ya que los bloques actuan como sombras

  object Hello {
    def main(args: Array[String]) =
      println("hello world!")
    // $scala Hello
  }

  object Foo {
    val x = 1
  }
  object Bar {
    val x = 2
  }
  object Baz {
    import Bar.x
    val y = Bar.x + Foo.x
  }
  println(Baz.y)                                  //> 3
  //En lo que respecta a java usar (), aca se usa el punto para añidar.
  //En el caso de Bar.x y Foo.x, estan llamado al valor x de cada objeto.
  //Por eso el resultado da 3.

}