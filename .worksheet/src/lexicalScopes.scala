object lexicalScopes {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(66); 
  println("Welcome to the Scala worksheet");$skip(34); 

  def square(x: Double) = x * x;System.out.println("""square: (x: Double)Double""");$skip(349); 
  def sqrt(x: Double) = {
    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    def improve(guess: Double, x: Double) =
      (guess + x / guess) / 2

    def isGoodEnough(guess: Double, x: Double) =
      ((square(guess)) - x) < 0.001
    sqrtIter(1.0, x)
  };System.out.println("""sqrt: (x: Double)Double""");$skip(14); 

  val x = 0;System.out.println("""x  : Int = """ + $show(x ));$skip(24); 
  def f(y: Int) = y + 1;System.out.println("""f: (y: Int)Int""");$skip(52); 
  val result = {
    val x = f(3)
    x * x
  } + x
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
  };System.out.println("""result  : Int = """ + $show(result ));$skip(391); 
  println(Baz.y)}
  //En lo que respecta a java usar (), aca se usa el punto para añidar.
  //En el caso de Bar.x y Foo.x, estan llamado al valor x de cada objeto.
  //Por eso el resultado da 3.

}
