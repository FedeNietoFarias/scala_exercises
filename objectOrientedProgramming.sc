object objectOrientedProgramming {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  //Adicion racional
  //Supongamos que queremos sumar 2 numeros racionales:
  /*def addRationalNumerator(n1: Int, d1: Int, n2: Int, d2: Int): Int
def addRationalDenominator(n1: Int, d1: Int, n2: Int, d2: Int): Int
  Es dificl gestionar todos estos numeradores y denominadores
  */
  
  //Es mas facil coincidir el numerador y denominador racional en una estructura de datos
  
  //CLASES
  //En scala lo de arriba se hace definiendo una clase:
  
  class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y
}
/*Aca tenemos 2 nuevas entidades:
un nuevo tipo que lo nombramos Rational,
un constructor Rational para crear elementos de este tipo
Scala mantiene los nombres y tipos de valores en diferentes espacios de nombres, por eso no hay
conflicto entre las 2 definiciones de Rational
*/

 //OBJETOS
 
 /*
 Llamamos a los elementos de un tipo de clases de objetos.
 Creamos un objeto prefijando una aplicacion del constructor de la clase con el operador NEW
 */
 new Rational(1, 2)                               //> res0: objectOrientedProgramming.Rational = objectOrientedProgramming$Ration
                                                  //| al$1@6bdf28bb
 
 //MIEMBROS DE UN OBJETO
 
 /*
 Los objetos de la clase Rational tienen dos miembros, numerador y denominador (1 y 2)
 
 */
 
 val x = new Rational(1, 2) // x: Rational = Rational@2abe0e27
                                                  //> x  : objectOrientedProgramming.Rational = objectOrientedProgramming$Rationa
                                                  //| l$1@6b71769e
x.numer // 1                                      //> res1: Int = 1
x.denom // 2                                      //> res2: Int = 2

//ARITMETICA RACIONAL

//Ahora podemos definir las funciones aritmeticas que implementan las reglas estandar:

/*n1 / d1 + n2 / d2 = (n1 * d2 + n2 * d1) / (d1 * d2)
n1 / d1 - n2 / d2 = (n1 * d2 - n2 * d1) / (d1 * d2)
n1 / d1 * n2 / d2 = (n1 * n2) / (d1 * d2)
n1 / d1 / n2 / d2 = (n1 * d2) / (d1 * n2)
n1 / d1 = n2 / d2 iff n1 * d2 = d1 * n2
*/

//IMPLEMENTACION DE ARITMETICA RACIONAL

def addRational(r: Rational, s: Rational): Rational =
  new Rational(
    r.numer * s.denom + s.numer * r.denom,
    r.denom * s.denom
  )                                               //> addRational: (r: objectOrientedProgramming.Rational, s: objectOrientedProgr
                                                  //| amming.Rational)objectOrientedProgramming.Rational

//Por lo tanto:

//makeString(addRational(new Rational(1, 2), new Rational(2, 3)))

//METODOS

/*
Uno puede empaquetar funciones que operan en una abstraccion de datos en la abstraccion de datos
en si. Tales funciones son llamadas metodos

Los numeros racionales, ademas de las funciones num y denom, ahora tendrian las funciones
add,sub,mul,div,equal,toString.
Ejemplo:


*/
class Rational2(x: Int, y: Int) {
  def numer = x
  def denom = y
  def add(r: Rational) =
    new Rational2(numer * r.denom + r.numer * denom, denom * r.denom)
  //def mul(r: Rational) = ...
  override def toString = numer + "/" + denom
}
//Tenga en cuenta que el modificador override declara que toString redefine un método que
//ya existe (en la clase java.lang.Object).

//Asi se podria usar la nueva abstraccion de Rational

val x2 = new Rational2(1, 3)                      //> x2  : objectOrientedProgramming.Rational2 = 1/3
val y = new Rational(5, 7)                        //> y  : objectOrientedProgramming.Rational = objectOrientedProgramming$Rationa
                                                  //| l$1@2752f6e2
val z = new Rational(3, 2)                        //> z  : objectOrientedProgramming.Rational = objectOrientedProgramming$Rationa
                                                  //| l$1@e580929
x2.add(y).add(z)                                  //> res3: objectOrientedProgramming.Rational2 = 107/42

//ABSTRACCIÓN DE DATOS

//Uno espera que los numeros racionales se simplifiquen , una alternativa es:
//simplicar la representacion en la clase cuando se construyen los objetos

class Rational3(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g
}

/*
 "gcd y g" son miembros privados, solo podemos acceder a ellos desde la clase Rational3.
 Calculamos gcd de inmediato, de modo que su valor se pueda reutilizar en num y denom.
 Tambien se puede llamar gcd al codigo de numer y denom:
*/
class Rational4(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  def numer = x / gcd(x, y)
  def denom = y / gcd(x, y)
}

//Es igualmente posible convertir num y denom en val, para que se calculen solo una vez:

/*class Rational5(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)
}*/

//Esto puede ser ventajoso si las funciones num y denom se llaman a menudo

//VISTA DEL CLIENTE

//Esta manera de elegir diferentes implementaciones sin afectar a los clientes se llama
//abstraccion de datos. Es una piedra angular en la ingeneria de software

//REFERENCIA PROPIA

/*
En el interior de una clase, el nombre this representa el objeto sobre el que se ejecuta el
metodo actual

Agregamos las funciones less y max a la clase racional:
*/

class Rational5(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)
  def less(that: Rational) =
  numer * that.denom < that.numer * denom

  def max(that: Rational) =
    if (this.less(that)) that else this
}

/*Tenga en cuenta que un nombre simple X , que se refiere a otro miembro de la clase, es una
abreviatura de this.x. Por tanto, una abreviatura de formular less es la sig:
def less(that: Rational) =
  this.numer * that.denom < that.numer * this.denom
*/

//CONDICIONES PREVIAS

/*
Supongamos que en nuestra clase Rational, el denominador tiene que ser positivo.
Podemos imponer esto llamando al require funcion:
*/
class Rational6(x: Int, y: Int) {
  require(y > 0, "denominator must be positive")
  
}

//require es una funcion predefinida, si la condicion da false, tira una cadena como arriba

//AFIRMACIONES

//Como hay require, hay assert, que toma una condicion y una cadena opcional de mensaje:

/*val x = sqrt(y)
assert(x3 >= 0)

Al igual require, un error assertarrojará también una excepción, pero es diferente:
AssertionError para assert, IllegalArgumentException para require.

Diferencia entre require y assert:

require se usa para imponer una condición previa a la persona que llama de una función.
assert se utiliza para verificar el código de la función en sí.
*/

//CONSTRUCTORES

/*Una clase introduce a un constructor implicitamente. Este es el constructor primario de la clase
Toma los parametros de la clase, y ejecuta (como ej: require) las declaraciones en el cuerpo
de la clase
*/

//Constructores auxiliares
//Estos constructores son nombrados por el this, ej:
class Rational7(x: Int, y: Int) {
  def this(x: Int) = this(x, 1)
  //...
}

//CLASES Y SUSTITUCIONES

/*
Anteriormente usamos un modelo de calculo basado en la susticion. Ahora lo ampliamos a modelo de
clases y objetos:
¿Cómo se new C(e1, …, en)evalúa una instanciación de la clase ?
Los argumentos de expresión e1, …, en se evalúan como los argumentos de una función normal. Eso es.
La expresión resultante, por ejemplo, new C(v1, …, vn)ya es un valor.
Supongamos:

class C(x1, …, xn) {
  …
  def f(y1, …, ym) = b
  …
}

Aca podemos ver que los parametros formales de la clase son: x1,...,xn.
La clase define un metodo f con parametros formales y1,...,ym.
*/

/*
¿Como se evalua la siguiente expresion?

new C(v1, …, vn).f(w1, …, wm)

la sustitución de los parámetros formales y1, …, ymde la función fpor los argumentos w1, …, wm,
la sustitución de los parámetros formales x1, …, xnde la clase Cpor los argumentos de la clase v1, …, vn,
la sustitución de la referencia propia thispor el valor del objeto new C(v1, …, vn).
*/


//OPERADORES
/*
Al principio, Rational tiene numero naturales como enteros.
Pero hay una diferencia notable:
Escribimos x+y, si "x" y "y" son enteros, pero
Escribimos r.add(s), si "r" y "s" son numeros racionales

En Scala podemos eliminar esta diferencia porque los operadores pueden usarse como identificadores
Entonces un identificador puede ser:
1-Alfanumérico : comienza con una letra, seguida de una secuencia de letras o números
2-Simbólico : comienza con un símbolo de operador, seguido de otros símbolos de operador.
3-El carácter de subrayado '_'cuenta como una letra.
4-Los identificadores alfanuméricos también pueden terminar en un guión bajo, seguido
de algunos símbolos de operador.

Ejemplos de identificadores:
x1 * +?%& vector_++ counter_=
*/

//Operadores para racionales

//A continuacion una definicion mas natural de clase Rational

class Rational8(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g
  def + (r: Rational) =
    new Rational(
      numer * r.denom + r.numer * denom,
      denom * r.denom
    )
  //def - (r: Rational) = ... Se hace la cuenta
  //def * (r: Rational) = ... Se hace la cuenta
}

//Los numeros racionales se pueden usar como int o double
val x8 = new Rational8(1, 2)                      //> x8  : objectOrientedProgramming.Rational8 = objectOrientedProgramming$Ratio
                                                  //| nal8$1@1cd072a9
val y8 = new Rational8(1, 3)                      //> y8  : objectOrientedProgramming.Rational8 = objectOrientedProgramming$Ratio
                                                  //| nal8$1@7c75222b
//x8 * x8 + y8 * y8

//REGLAS DE PROCEDENCIA

//La siguiente tabla enumera los caracteres en orden creciente de prioridad a prioridad, ej:

/*
(all letters)
|
^
&
< >
= !
:
+ -
* / %
(all other special characters)
*/


//CLASES ABSTRACTAS

//Considerar la tarea de escribir una clase para conjuntos de enteros con las siguientes operaciones

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}
//Las clases abstractas pueden contener miembros a los que le falta una implementacion (incl y contains)
//NO SE PUEDEN CREAR INSTANCIA DE UNA CLASE ABSTRACTA CON EL OPERADOR NEW

//EXTENSIONES DE CLASE

/*Consideremos la implementaciones de arboles binarios
Hay 2 tipos de arboles, un arbol para el conjunto vacio y otro que consta de un numero
entero y dos subarboles.
Implementemos:
*/

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
}

//Ambos extienden de la clase IntSet, esto implica que ambas clases se ajustan al tipo IntSet
/*
Un objeto Empty o NonEmpty puede usarse donde sea que IntSet requiera un objeto de tipo
IntSet es la superclase de Empty y NonEmpty (estas 2 son subclases de IntSet)
Si no se especifica cual es la super clase, siempre por defecto tiene la clase estandar Object de Java
Las superclases directas o indirecta de "c" se llaman clases bases de "c",
por lo tanto: las clases bases de NonEmpty y Empty son: Object y IntSet
*/

//IMPLEMENTACION Y ANULACION
//Tambien es posible redefinir una definicion existente, no abstracta en una subclase con override

abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo = 2
  def bar = 3
}

//DEFINICIONES DE OBJETO

//En el IntSet hay 1 solo vacio, por eso es de gusto crear muchas instancias de este, asi que
//lo podemos expresar de una manera mejor:
object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
}
//Esto define un objeto singleton llamado Empty, con Empty no deben crear otras instancias
//Los objetos Singleton son valores, por lo que Empty se evalua a si mismo.

//ENLACE DINAMICO

/*
Los lenguajes dinamicos mantienen en el envio dinamico de datos.
Esto quiere decir que el codigo pedido por una llamada al metodo depende del tipo de tiempo
en ejecucion del objeto que contiene el metodo.
*/

Empty contains 1                                  //> res4: Boolean = false
new NonEmpty(7, Empty, Empty) contains 7          //> res5: Boolean = true


//RASGOS

/*En Scala, una clase solo puede tener una superclase.
se usa el TRAIT si una clase tiene varios supertipos naturales para heredar en el codigo
Un rasgo se declara como clase abstracta, solo que se escribe trait

*/

trait Planar {
  def height: Int
  def width: Int
  def surface = height * width
}

/*Las clases, los objetos y los rasgos pueden heredar, como máximo, una clase pero
muchos rasgos arbitrarios:

class Square extends Shape with Planar with Movable …

Por otro lado, los rasgos no pueden tener (valor) parámetros, solo las clases pueden.
*/

//EJERCICIO FINAL

abstract class Reducer(init: Int) {
  def combine(x: Int, y: Int): Int
  def reduce(xs: List[Int]): Int =
    xs match {
      case Nil => init
      case y :: ys => combine(y, reduce(ys))
    }
}

object Product extends Reducer(1) {
  def combine(x: Int, y: Int): Int = x * y
}

object Sum extends Reducer(0) {
  def combine(x: Int, y: Int): Int = x + y
}

val nums = List(1, 2, 3, 4)                       //> nums  : List[Int] = List(1, 2, 3, 4)

Product.reduce(nums)                              //> res6: Int = 24
Sum.reduce(nums)                                  //> res7: Int = 10

}