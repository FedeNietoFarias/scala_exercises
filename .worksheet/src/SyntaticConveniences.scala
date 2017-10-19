object SyntaticConveniences {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala worksheet");$skip(169); 

	//Para empalmar valores en constante String en tiempo de ejecución, puede usar
	//la interpolación de cadenas :
  def greet(name: String): String =
  s"Hello, $name!";System.out.println("""greet: (name: String)String""");$skip(15); val res$0 = 
greet("Scala");System.out.println("""res0: String = """ + $show(res$0));$skip(59); val res$1 = 
//shouldBe "Hello, Scala!"
greet("Functional Programming");System.out.println("""res1: String = """ + $show(res$1));$skip(404); 
//shouldBe  "Hello, Functional Programming!"
//Fijemosnos que en estos 2 casos la variable name toma en la def el valor entre parentesis

//Después de haber prefijado el literal de cadena s, puede introducir valores dinámicos en él $.
//Si desea empalmar una expresión compleja (más que un simple identificador), envuélvala con llaves:
def greet2(name: String): String =
  s"Hello, ${name.toUpperCase}!";System.out.println("""greet2: (name: String)String""");$skip(17); val res$2 = 

greet2("Scala");System.out.println("""res2: String = """ + $show(res$2));$skip(316); 
 //shouldBe "Hello, SCALA!"
 
/*TUPLAS

Vimos anteriormente que las clases de casos son útiles para agregar información.
Sin embargo, a veces desea agregar información sin tener que definir una clase de
caso completa para ella. En tal caso, puede usar tuplas :
*/
def pair(i: Int, s: String): (Int, String) = (i, s);System.out.println("""pair: (i: Int, s: String)(Int, String)""");$skip(17); val res$3 = 

pair(42, "foo");System.out.println("""res3: (Int, String) = """ + $show(res$3));$skip(38); val res$4 = 
//shouldBe (42, "foo")
pair(0, "bar");System.out.println("""res4: (Int, String) = """ + $show(res$4));$skip(138); 
//shouldBe (0,"bar")

 //Puede recuperar los elementos de una tupla utilizando un patrón de tuplas :
 val is: (Int, String) = (42, "foo");System.out.println("""is  : (Int, String) = """ + $show(is ));$skip(78); 

is match {
  case (i, s) =>
    //i shouldBe 42
    //s shouldBe "foo"
				};$skip(54); 
//o simplemente:
val is2: (Int, String) = (42, "foo");System.out.println("""is2  : (Int, String) = """ + $show(is2 ));$skip(17); 

val (i, s) = is;System.out.println("""i  : Int = """ + $show(i ));System.out.println("""s  : String = """ + $show(s ));$skip(171); 
//i shouldBe 42
//s shouldBe "foo"

//puede recuperar el primer elemento con el _1miembro, el segundo elemento con el _2miembro, etc:
val is3: (Int, String) = (42, "foo");System.out.println("""is3  : (Int, String) = """ + $show(is3 ));$skip(7); val res$5 = 
is3._1;System.out.println("""res5: Int = """ + $show(res$5));$skip(21); val res$6 = 
//shouldBe 42
is3._2
//shouldBe "foo"

//FUNCIONES COMO OBJETOS
//El tipo de función A => Bes solo una abreviatura de la clase scala.Function1[A, B], que
//se define de la siguiente manera.
//package scala
trait Function1[A, B] {
  def apply(x: A): B
};System.out.println("""res6: String = """ + $show(res$6));$skip(558); val res$7 = 
//Las funciones son objetos con mètodos apply (aplicados)

/*Una función anónima como:
(x: Int) => x*x
Se amplia a
{
  class AnonFun extends Function1[Int, Int] {
    def apply(x: Int) = x * x
  }
  new AnonFun
}
*/
//O mas corto utilizando la sintaxis de clase anónima
new Function1[Int, Int] {
  def apply(x: Int) = x * x
};System.out.println("""res7: SyntaticConveniences.Function1[Int,Int] = """ + $show(res$7));$skip(172); 

//Una llamada de función como f(a,b), donde f es un valor de algún tipo de clase, se amplia a:

//f.apply(a,b)


//Entonces la OO traduccion de:
val f = (x: Int) => x * x;System.out.println("""f  : Int => Int = """ + $show(f ));$skip(5); val res$8 = 
f(7);System.out.println("""res8: Int = """ + $show(res$8));$skip(74); 
//Seria:
val f2 = new Function1[Int, Int] {
  def apply(x: Int) = x * x
};System.out.println("""f2  : SyntaticConveniences.Function1[Int,Int] = """ + $show(f2 ));$skip(12); val res$9 = 
f2.apply(7)

/*Hasta ahora venimos usando tipos de datos de la biblioteca estándar de métodos como
map, flatMap y filter.
Por lo tanto en vez de escribir:
xs.map(x => x + 1)
Se puede escribir
for (x <- xs) yield x + 1
Puedes leerlo como "para cada valor, que nombre 'x', en 'xs', devuelve 'x + 1'".
OTRO EJEMPLO:
xs.filter(x => x % 2 == 0)
Se puede escribir:
for (x <- xs if x % 2 == 0) yield x
El beneficio de esta sintaxis se vuelve más evidente cuando se combina con el anterior:
for (x <- xs if x % 2 == 0) yield x + 1

/ Equivale a lo siguiente:
xs.filter(x => x % 2 == 0).map(x => x + 1)

*/

/* Finalmente en lugar de escribir:
xs.flatMap(x => ys.map(y => (x, y)))

Se puede escribir:

for (x <- xs; y <- ys) yield (x, y)

Puede leerlo como "para cada valor 'x' en 'xs', y luego para cada valor 'y' en 'ys',
devolver '(x, y)'".


*/

//SE PUEDE PONER LAS COSAS JUNTAS
/*EJEMPLO:
for {
  x <- xs if x % 2 == 0
  y <- ys
} yield (x, y)

EL CODIGO EQUIVALENTE SIN SUGAR ES EL SIGUIENTE

xs.filter { x =>
  x % 2 == 0
}.flatMap { x =>
  ys.map { y =>
    (x, y)
  }
}

*/

//Parametros del metodo:
/*Parametros nombrados
A veces puede ser difícil determinar cuál es el significado de cada parámetro
que se pasa a una función. Considere, por ejemplo, la siguiente expresión:

Range(1,10,2)

Se puede mejorar a legibilidad mediante el USO DE PARAMETROS CON NOMBRE

Range(start = 1, end = 10, step = 2)

Asi es mas claro que esta definido del 1 al 10, en incrementos de a 2

*/

/*Valores predeterminados

Puede haber valores predeterminados. Refinando el range:

case class Range(start: Int, end: Int, step: Int = 1)

En este caso el STEP tiene por valor de defecto 1

No hace falta ponerlo, ya que el compilador se encarga de ponerlo solo:

*/
case class Range(start: Int, end: Int, step: Int = 1);System.out.println("""res9: Int = """ + $show(res$9));$skip(1825); 

val xs = Range(start = 1, end = 10);System.out.println("""xs  : SyntaticConveniences.Range = """ + $show(xs ));$skip(9); val res$10 = 

xs.step;System.out.println("""res10: Int = """ + $show(res$10));$skip(128); 
//shouldBe 1

//Parametros repetidos:
def average(x: Int, xs: Int*): Double =
  (x :: xs.to[List]).sum.toDouble / (xs.size + 1);System.out.println("""average: (x: Int, xs: Int*)Double""");$skip(12); val res$11 = 

average(1);System.out.println("""res11: Double = """ + $show(res$11));$skip(29); val res$12 = 
//shouldBe 1.0
average(1, 2);System.out.println("""res12: Double = """ + $show(res$12));$skip(32); val res$13 = 
//shouldBe 1.5
average(1, 2, 3)
//shouldBe 2
/*La average función toma al menos un Int parámetro y luego un número arbitrario de otros valores
y calcula su promedio. Al forzar a los usuarios a suministrar al menos un parámetro, les hacemos
imposible calcular el promedio de una lista vacía de números.
*/

/*A veces desea proporcionar cada elemento de una lista con tantos parámetros.
Puede hacer eso agregando una : _*asignación de tipo a su lista:

val xs: List[Int] = …
average(1, xs: _*)
*/

//TIPOS DE ALIAS
/*De la misma manera que puede dar nombres significativos a las expresiones, puede dar
nombres significativos para escribir expresiones :
*/

type Result = Either[String, (Int, Int)];System.out.println("""res13: Double = """ + $show(res$13));$skip(814); 
def divide(dividend: Int, divisor: Int): Result =
  if (divisor == 0) Left("Division by zero")
  else Right((dividend / divisor, dividend % divisor));System.out.println("""divide: (dividend: Int, divisor: Int)SyntaticConveniences.Result""");$skip(13); val res$14 = 
divide(6, 4);System.out.println("""res14: SyntaticConveniences.Result = """ + $show(res$14));$skip(38); val res$15 = 
//shouldBe Right((1, 2))
divide(2, 0);System.out.println("""res15: SyntaticConveniences.Result = """ + $show(res$15));$skip(50); val res$16 = 
// shouldBe Left("Division by zero")
divide(8, 4);System.out.println("""res16: SyntaticConveniences.Result = """ + $show(res$16))}
//shouldBe Right((2,0))

}
