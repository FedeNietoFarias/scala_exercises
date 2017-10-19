object SyntaticConveniences {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	//Para empalmar valores en constante String en tiempo de ejecución, puede usar
	//la interpolación de cadenas :
  def greet(name: String): String =
  s"Hello, $name!"                                //> greet: (name: String)String
greet("Scala")                                    //> res0: String = Hello, Scala!
//shouldBe "Hello, Scala!"
greet("Functional Programming")                   //> res1: String = Hello, Functional Programming!
//shouldBe  "Hello, Functional Programming!"
//Fijemosnos que en estos 2 casos la variable name toma en la def el valor entre parentesis

//Después de haber prefijado el literal de cadena s, puede introducir valores dinámicos en él $.
//Si desea empalmar una expresión compleja (más que un simple identificador), envuélvala con llaves:
def greet2(name: String): String =
  s"Hello, ${name.toUpperCase}!"                  //> greet2: (name: String)String

greet2("Scala")                                   //> res2: String = Hello, SCALA!
 //shouldBe "Hello, SCALA!"
 
/*TUPLAS

Vimos anteriormente que las clases de casos son útiles para agregar información.
Sin embargo, a veces desea agregar información sin tener que definir una clase de
caso completa para ella. En tal caso, puede usar tuplas :
*/
def pair(i: Int, s: String): (Int, String) = (i, s)
                                                  //> pair: (i: Int, s: String)(Int, String)

pair(42, "foo")                                   //> res3: (Int, String) = (42,foo)
//shouldBe (42, "foo")
pair(0, "bar")                                    //> res4: (Int, String) = (0,bar)
//shouldBe (0,"bar")

 //Puede recuperar los elementos de una tupla utilizando un patrón de tuplas :
 val is: (Int, String) = (42, "foo")              //> is  : (Int, String) = (42,foo)

is match {
  case (i, s) =>
    //i shouldBe 42
    //s shouldBe "foo"
				}
//o simplemente:
val is2: (Int, String) = (42, "foo")              //> is2  : (Int, String) = (42,foo)

val (i, s) = is                                   //> i  : Int = 42
                                                  //| s  : String = foo
//i shouldBe 42
//s shouldBe "foo"

//puede recuperar el primer elemento con el _1miembro, el segundo elemento con el _2miembro, etc:
val is3: (Int, String) = (42, "foo")              //> is3  : (Int, String) = (42,foo)
is3._1                                            //> res5: Int = 42
//shouldBe 42
is3._2                                            //> res6: String = foo
//shouldBe "foo"

//FUNCIONES COMO OBJETOS
//El tipo de función A => Bes solo una abreviatura de la clase scala.Function1[A, B], que
//se define de la siguiente manera.
//package scala
trait Function1[A, B] {
  def apply(x: A): B
}
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
}                                                 //> res7: SyntaticConveniences.Function1[Int,Int] = SyntaticConveniences$$anon$
                                                  //| 1@35fb3008

//Una llamada de función como f(a,b), donde f es un valor de algún tipo de clase, se amplia a:

//f.apply(a,b)


//Entonces la OO traduccion de:
val f = (x: Int) => x * x                         //> f  : Int => Int = SyntaticConveniences$$$Lambda$11/55909012@531be3c5
f(7)                                              //> res8: Int = 49
//Seria:
val f2 = new Function1[Int, Int] {
  def apply(x: Int) = x * x
}                                                 //> f2  : SyntaticConveniences.Function1[Int,Int] = SyntaticConveniences$$anon$
                                                  //| 2@52af6cff
f2.apply(7)                                       //> res9: Int = 49

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
case class Range(start: Int, end: Int, step: Int = 1)

val xs = Range(start = 1, end = 10)               //> xs  : SyntaticConveniences.Range = Range(1,10,1)

xs.step                                           //> res10: Int = 1
//shouldBe 1

//Parametros repetidos:
def average(x: Int, xs: Int*): Double =
  (x :: xs.to[List]).sum.toDouble / (xs.size + 1) //> average: (x: Int, xs: Int*)Double

average(1)                                        //> res11: Double = 1.0
//shouldBe 1.0
average(1, 2)                                     //> res12: Double = 1.5
//shouldBe 1.5
average(1, 2, 3)                                  //> res13: Double = 2.0
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

type Result = Either[String, (Int, Int)]
def divide(dividend: Int, divisor: Int): Result =
  if (divisor == 0) Left("Division by zero")
  else Right((dividend / divisor, dividend % divisor))
                                                  //> divide: (dividend: Int, divisor: Int)SyntaticConveniences.Result
divide(6, 4)                                      //> res14: SyntaticConveniences.Result = Right((1,2))
//shouldBe Right((1, 2))
divide(2, 0)                                      //> res15: SyntaticConveniences.Result = Left(Division by zero)
// shouldBe Left("Division by zero")
divide(8, 4)                                      //> res16: SyntaticConveniences.Result = Right((2,0))
//shouldBe Right((2,0))

}