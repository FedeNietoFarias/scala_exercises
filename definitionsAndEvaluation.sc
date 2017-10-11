object definitionsAndEvaluation {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  3.14159 * 10 * 10                               //> res0: Double = 314.159
  val radius = 10                                 //> radius  : Int = 10
  val pi = 3.14159                                //> pi  : Double = 3.14159
  pi * radius * radius                            //> res1: Double = 314.159
  def square(x: Double) = x * x                   //> square: (x: Double)Double
  square(3.0)                                     //> res2: Double = 9.0
  def area(radius: Double): Double = 3.14159 * square(radius)
                                                  //> area: (radius: Double)Double
  area(10)                                        //> res3: Double = 314.159
  def sumOfSquares(x: Double, y: Double) = square(x) + square(y)
                                                  //> sumOfSquares: (x: Double, y: Double)Double
  val x = 2                                       //> x  : Int = 2
  val y = square(x)                               //> y  : Double = 4.0
  sumOfSquares(3, 2 + 2)                          //> res4: Double = 25.0
  sumOfSquares(3, 4)                              //> res5: Double = 25.0
  square(3) + square(4)                           //> res6: Double = 25.0
  //Ir resolviendo de izquierda a derecha, paso a paso.
  //Modelo de sustitucion se formaliza en el calculo, lo que es la base de la programacion funcional.
	def loop: Int =loop                       //> loop: => Int
	// BUCLE INFINITO PARA LA VARIABLE val xr = loop
	sumOfSquares(3, 2 + 2)                    //> res7: Double = 25.0
/*square(3) + square(2 + 2)
3 * 3 + square(2 + 2)
9 + square(2 + 2)
9 + (2 + 2) * (2 + 2)
9 + 4 * (2 + 2)
9 + 4 * 4
25
	COMO HAY QUE PENSARLO*/
	//Call-by-value Evalua cada argumento de funcion solo una vez.
	//Call-by-name Un argumento de función no se evalúa si el parámetro no se utiliza en el cuerpo de la función
	def triangleArea(base: Double, height: Double) : Double =
	(base*height)/2                           //> triangleArea: (base: Double, height: Double)Double
	
	triangleArea(3,4)                         //> res8: Double = 6.0
	triangleArea(5,6)                         //> res9: Double = 15.0
	
	
	
}