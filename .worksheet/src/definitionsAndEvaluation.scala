object definitionsAndEvaluation {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(20); val res$0 = 
  3.14159 * 10 * 10;System.out.println("""res0: Double = """ + $show(res$0));$skip(18); 
  val radius = 10;System.out.println("""radius  : Int = """ + $show(radius ));$skip(19); 
  val pi = 3.14159;System.out.println("""pi  : Double = """ + $show(pi ));$skip(23); val res$1 = 
  pi * radius * radius;System.out.println("""res1: Double = """ + $show(res$1));$skip(32); 
  def square(x: Double) = x * x;System.out.println("""square: (x: Double)Double""");$skip(14); val res$2 = 
  square(3.0);System.out.println("""res2: Double = """ + $show(res$2));$skip(62); 
  def area(radius: Double): Double = 3.14159 * square(radius);System.out.println("""area: (radius: Double)Double""");$skip(11); val res$3 = 
  area(10);System.out.println("""res3: Double = """ + $show(res$3));$skip(65); 
  def sumOfSquares(x: Double, y: Double) = square(x) + square(y);System.out.println("""sumOfSquares: (x: Double, y: Double)Double""");$skip(12); 
  val x = 2;System.out.println("""x  : Int = """ + $show(x ));$skip(20); 
  val y = square(x);System.out.println("""y  : Double = """ + $show(y ));$skip(25); val res$4 = 
  sumOfSquares(3, 2 + 2);System.out.println("""res4: Double = """ + $show(res$4));$skip(21); val res$5 = 
  sumOfSquares(3, 4);System.out.println("""res5: Double = """ + $show(res$5));$skip(24); val res$6 = 
  square(3) + square(4);System.out.println("""res6: Double = """ + $show(res$6));$skip(179); 
  //Ir resolviendo de izquierda a derecha, paso a paso.
  //Modelo de sustitucion se formaliza en el calculo, lo que es la base de la programacion funcional.
	def loop: Int =loop;System.out.println("""loop: => Int""");$skip(74); val res$7 = 
	// BUCLE INFINITO PARA LA VARIABLE val xr = loop
	sumOfSquares(3, 2 + 2);System.out.println("""res7: Double = """ + $show(res$7));$skip(394); 
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
	(base*height)/2;System.out.println("""triangleArea: (base: Double, height: Double)Double""");$skip(21); val res$8 = 
	
	triangleArea(3,4);System.out.println("""res8: Double = """ + $show(res$8));$skip(19); val res$9 = 
	triangleArea(5,6);System.out.println("""res9: Double = """ + $show(res$9))}
	
	
	
}
