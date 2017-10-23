object imperativeProgramming {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //RECORDATORIO: MODELO DE SUSTITUCION
  /*
  Un nombre se evalua reemplazandolo por el lado derecho de su definicion
  y asì con todo lo que son funciones y argumentos reales.
  
  */
  //Vamos a un ejemplo con 2 funciones iterate y square
  
  /*def iterate(n: Int, f: Int => Int, x: Int) =
  if (n == 0) x
 else iterate (n - 1, f, f(x))
 def square(x: Int) = x * x
  
  Luego la llamada iterate(1, square, 3)se reescribe de la siguiente manera:
  
iterate(1, square, 3)
if (1 == 0) 3 else iterate(1 - 1, square, square(3))
iterate(0, square, square(3))
iterate(0, square, 3 * 3)
iterate(0, square, 9)
if (0 == 0) 9 else iterate(0 - 1, square, square(9))
9
  */
  
 //La reescritura se puede hacer en cualquier parte del proceso, ya que todas conducen
 //a la misma solucion, es la teoria detras de la programacion funcional. Ej:
 
 /*if (1 == 0) 3 else iterate(1 - 1, square, square(3))
iterate(0, square, square(3))

// OR
if (1 == 0) 3 else iterate(1 - 1, square, square(3))
if (1 == 0) 3 else iterate(1 - 1, square, 3 * 3)
  
 */
  
//OBJETOS CON ESTADO

/*El mundo es un conjunto de objetos, y cada estado cambia con el transcurso del tiempo
Un objeto tiene un estado si su comportamiento esta influenciado por su historial
Ejemplo: una cuenta bancaria tiene un estado, porque la respuesta a la pregunta "
¿Puedo retirar 100 CHF?" Puede variar a lo largo de la vida de la cuenta.
*/

//IMPLEMENTACION DEL ESTADO

//Cada forma del estado se construye a partir de variables,
//Las variables se escriben con "var" en vez de "val", y son una definicion de valor, ej:
 var x: String = "abc"                            //> x  : String = abc
var count = 111                                   //> count  : Int = 111

/*Al igual que una definición de valor, una definición de variable asocia un valor con un nombre.
Pero en el caso de variables se puede cambiar mediante una asignacion
*/
x = "hi"
count = count + 1

//ESTADO EN OBJETOS

/*
En la práctica, los objetos con estado generalmente están representados por objetos que tienen
algunos miembros variables. Aquí hay una clase que modela una cuenta bancaria:
*/

class BankAccount {
  private var balance = 0
  def deposit(amount: Int): Int = {
    if (amount > 0) balance = balance + amount
    balance
  }
  def withdraw(amount: Int): Int =
    if (0 < amount && amount <= balance) {
      balance = balance - amount
      balance
    } else throw new Error("insufficient funds")
}

//La clase BankAccountdefine una variable balanceque contiene el saldo actual de la cuenta.
val account0 = new BankAccount                    //> account0  : imperativeProgramming.BankAccount = imperativeProgramming$BankA
                                                  //| ccount$1@7c75222b

//TRABAJANDO CON OBJETOS MUTABLES

//Programa que manipula cuentas bancarias
val account = new BankAccount // account: BankAccount = BankAccount
                                                  //> account  : imperativeProgramming.BankAccount = imperativeProgramming$BankAc
                                                  //| count$1@4c203ea1
account deposit 50 //                             //> res0: Int = 50
account withdraw 20 // res1: Int = 30             //> res1: Int = 30
account withdraw 20 // res2: Int = 10             //> res2: Int = 10
account withdraw 15                 // java.lang.Error: insufficient funds
                                                  //> java.lang.Error: insufficient funds
                                                  //| 	at imperativeProgramming$BankAccount$1.withdraw(imperativeProgramming.sc
                                                  //| ala:78)
                                                  //| 	at imperativeProgramming$.$anonfun$main$1(imperativeProgramming.scala:91
                                                  //| )
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$anonfun$$ex
                                                  //| ecute$1(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:76)
                                                  //| 	at imperativeProgramming$.main(imperativeProgramming.scala:1)
                                                  //| 	at imperativeProgramming.main(imperativeProgramming.scala)

//Nos tenemos que fijar el procedimiento y ver como la misma operacion produce 2 res diferentes


//IDENTIDAD Y CAMBIO

/*La asignacion plantea problemas al decidir si dos expresiones son las mismas, ej:

val x = E; val y = E

Esto quiere decir que "x" e "y" son iguales, entonces tambien se puede escribir:

val x = E; val y = x <-- esta propiedad se suele llamar "transparencia referencial"

Pero una vez que permitimos la asignacion, las 2 formulaciones son distinas, ej:
*/

val x1 = new BankAccount
val y1 = new BankAccount

//EQUIVALENCIA OPERACIONAL

//SON IGUALES X E Y?
/*
SON SOLAMENTE EQUIVALENTES SI NINGUNA PRUEBA PUEDE DISTINGUIRLOS

*/

//PRUEBA DE EQUIVALENCIA OPERACIONAL
/*
Para probar si "x" e "y" son iguales, tienen que ejecturase con una secuencia aribtraria "s",
que involucre a ambos y observar los resultados
*/

/*val x = new BankAccount
val y = new BankAccount
f(x, y)*/

//Luego, ejecute las definiciones con otra secuencia S obtenida al renombrar todas las
//ocurrencias de y por x en S:

/*val x = new BankAccount
val y = new BankAccount
f(x, x)

A resultados diferentes, "x" e "y" son totalmente diferentes, si producen lo mismo, son lo mismo

*/

//Hagamos la prueba:

val x2 = new BankAccount
val y = new BankAccount
x2 deposit 30
y withdraw 20   // java.lang.Error: insufficient funds

//Ahora cambie el nombre de todas las ocurrencias de ycon xen esta secuencia. Obtenemos:

val x3 = new BankAccount
val y3 = new BankAccount
x3 deposit 30
x3 withdraw 20
//shouldBe 10

//Por los resultados anteriores concluimos que "x" e "y" no son iguales.

//Pero si definimos:

val x4 = new BankAccount
val y4 = x4

//Ninguna secuencia puede distinguirlas ya que son iguales

//MODELO DE ASIGNACION Y SUSTITUCION

/*Como vimos anteriormente el modelo de sustitucion deja de ser valido cuando asignamos una tarea
Pero se puede adaptar este modelo introduciendo una tienda, pero se vuelve mas complicado

*/

//IMPERATIVE LOOPS

//Tambien se pueden hacer loops (bucles) con el while:

def power(x: Double, exp: Int): Double = {
  var r = 1.0
  var i = exp
  while (i > 0) { r = r * x; i = i - 1 }
  r
  }
  //Mientras la condición de un enunciado while sea true, su cuerpo es evaluado.
  
  //FOR-LOOPS
  
 //En Scala hay una especie de for-loops:
 
 for (i <- 1 until 3) { System.out.print(i + " ") }
 
 //Esto muestra 1 y 2, estos bucles traducen las expresiones for, pero usan el foreach combinador
 //en lugar del map y flatMap
 
 //foreachse define en colecciones con elementos de tipo de la Asiguiente manera:
 
 //def foreach(f: A => Unit): Unit =
  // apply `f` to each element of the collection
for (i <- 1 until 3; j <- "abc") println(s"$i $j")

//Esto quiere decir:

(1 until 3) foreach (i => "abc" foreach (j => println(s"$i $j")))

//EJERCICIO FINAL

def factorial(n: Int): Int = {
  var result =
1

  var i =
1

  while (i <= n) {
    result = result * i
    i = i +
1

  }
  result
}

//factorial(2) shouldBe 2
//factorial(3) shouldBe 6
//factorial(4) shouldBe 24
//factorial(5) shouldBe 120
}