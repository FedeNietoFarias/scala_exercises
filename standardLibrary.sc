object standardLibrary {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  //LISTAS en SCALA
  val fruit = List("apples", "oranges", "pears")  //> fruit  : List[String] = List(apples, oranges, pears)
val nums = List(1, 2, 3, 4)                       //> nums  : List[Int] = List(1, 2, 3, 4)
val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
                                                  //> diag3  : List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
                                                  //| 
val empty = List()                                //> empty  : List[Nothing] = List()
//Los elementos no se pueden cambiar, y deben ser del mismo tipo

//El tipo de una lista con elementos de tipo Testá escrito List[T]:
val fruit2: List[String] = List("apples", "oranges", "pears")
                                                  //> fruit2  : List[String] = List(apples, oranges, pears)
val nums2: List[Int] = List(1, 2, 3, 4)           //> nums2  : List[Int] = List(1, 2, 3, 4)
val diag32: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
                                                  //> diag32  : List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1)
                                                  //| )
val empty2: List[Nothing] = List()                //> empty2  : List[Nothing] = List()

//Las listas se construyen de listas vacias Nil
//y la operacion de construccion x :: xs que da una nueva lista con el
//primer elemento x, seguido de los elementos xs
val fruit3 = "apples" :: ("oranges" :: ("pears" :: Nil))
                                                  //> fruit3  : List[String] = List(apples, oranges, pears)
val nums3 = 1 :: (2 :: (3 :: (4 :: Nil)))         //> nums3  : List[Int] = List(1, 2, 3, 4)
val empty3 = Nil                                  //> empty3  : scala.collection.immutable.Nil.type = List()

//La asociacion correcta es emitiendo los parentesis, por lo tanto:
val nums4 = 1 :: 2 :: 3 :: 4 :: Nil               //> nums4  : List[Int] = List(1, 2, 3, 4)

nums match {
	//Lista de entero que empieza con 1 y sigue con 2
  case 1 :: 2 :: xs =>
  //  Lista con solo 1 de largo
  case x :: Nil =>
  // Lista que tiene `x :: Nil`
  case List(x) =>
  // Lista vacia, también llamada `Nil`
  case List() =>
}
//MANERA DE ORDENAR LA LISTA ASCENDENTEMENTE
//def insertionSort(xs: List[Int]): List[Int] = xs match {
  //case List() => List()
  //case y :: ys => insert(y, insertionSort(ys))}

//Ejercicio
val cond: (Int, Int) => Boolean =
(x,y) => x < y                                    //> cond  : (Int, Int) => Boolean = standardLibrary$$$Lambda$11/99347477@21bcff
                                                  //| b5

def insert(x: Int, xs: List[Int]): List[Int] =
  xs match {
    case List() => x ::
Nil

    case y :: ys =>
      if (cond(x, y)) x :: y :: ys
      else y :: insert(x, ys)
  }                                               //> insert: (x: Int, xs: List[Int])List[Int]
//insert(2, 1 :: 3 :: Nil) shouldBe (1 :: 2 :: 3 :: Nil)
//insert(1, 2 :: 3 :: Nil) shouldBe (1 :: 2 :: 3 :: Nil)
//insert(3, 1 :: 2 :: Nil) shouldBe (1 :: 2 :: 3 :: Nil)


//El mapeo esa la iteracion que le mandes, en este ejemplo a todos los Int de la lista
//les suma 1
List(1, 2, 3).map(x => x + 1) == List(2, 3, 4)    //> res0: Boolean = true

//El filter filtra los elementos a travez de lo que le pongas en la iteracion
List(1, 2, 3).filter(x => x % 2 == 0) == List(2)  //> res1: Boolean = true

//el flatMap Igual que los anteriores, pero te los aplana en la lista (seguido)
val xs =
  List(1, 2, 3).flatMap { x =>
    List(x, 2 * x, 3 * x)
  }                                               //> xs  : List[Int] = List(1, 2, 3, 2, 4, 6, 3, 6, 9)
xs == List(1, 2, 3, 2, 4, 6, 3, 6, 9)             //> res2: Boolean = true

//Representamos un valor opcional de tipo Acon el tipo Option[A]. Esto es útil para implementar,
//por ejemplo, funciones parcialmente definidas:
//def sqrt(x: Double): Option[Double] =..
//Una Option[A]puede ser None(si no hay valor) o Some[A] (si hay un valor):
//def sqrt(x: Double): Option[Double] =
 //if (x < 0) None else Some(…)

//ES POSIBLE DESCOMPONER LAS OPCIONES CON LA APARICION DE PATRONES
/*  def foo(x: Double): String =
  sqrt(x) match {
    case None => "no result"
    case Some(y) => y.toString
  }
  */
  
 //EJERCICIOS CON FILTER, FLAT Y FLATMAP
 /*Some(1).map(x => x + 1) shouldBe Some(2)
None.map((x: Int) => x + 1) shouldBe None

Some(3)
.map(x => x + 1) shouldBe
Some(4)
*/

/*Some(1).filter(x => x % 2 == 0) shouldBe None
Some(2).filter(x => x % 2 == 0) shouldBe Some(2)

Some(4)
.filter(x => x % 2 == 0) shouldBe
Some(4)*/

/*Some(1).flatMap(x => Some(x + 1)) shouldBe Some(2)
None.flatMap((x: Int) => Some(x + 1)) shouldBe None

Some(3)
.flatMap(x => Some(x + 1)) shouldBe
Some(4)
*/
 
//Es como el try catch de java, se puede ver como el Failure es el catch
/*def sqrt(x: Double): Try[Double] =
  if (x < 0) Failure(new IllegalArgumentException("x must be positive"))
  else Success(…)
  */
  
 //EN EL EITHER ES COMO EL TRY PERO TENES UNA O LA OTRA, LEFT O RIGHT, ejemplo:
 /*def sqrt(x: Double): Either[String, Double] =
  if (x < 0) Left("x must be positive")
  else Right(…)
  */
 //Eithertambién tiene un filterOrElsemétodo que convierte un Rightvalor en un
 // Leftvalor si no satisface un predicado dado:
 //Right(1).filterOrElse(x => x % 2 == 0, "Odd value") shouldBe Left("Odd value")
 
 //EJERCICIO FINAL
 	def triple(x: Int): Int = 3 * x           //> triple: (x: Int)Int

def tripleEither(x: Either[String, Int]): Either[String, Int] =
  x.right.map(triple)                             //> tripleEither: (x: Either[String,Int])Either[String,Int]
 	 
 tripleEither(Right(1))                           //> res3: Either[String,Int] = Right(3)
 tripleEither(Left("not a number"))               //> res4: Either[String,Int] = Left(not a number)
}