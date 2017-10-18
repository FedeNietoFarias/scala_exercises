object standardLibrary {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(68); 
  println("Welcome to the Scala worksheet");$skip(69); 
  //LISTAS en SCALA
  val fruit = List("apples", "oranges", "pears");System.out.println("""fruit  : List[String] = """ + $show(fruit ));$skip(28); 
val nums = List(1, 2, 3, 4);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(62); 
val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1));System.out.println("""diag3  : List[List[Int]] = """ + $show(diag3 ));$skip(19); 
val empty = List();System.out.println("""empty  : List[Nothing] = """ + $show(empty ));$skip(196); 
//Los elementos no se pueden cambiar, y deben ser del mismo tipo

//El tipo de una lista con elementos de tipo Testá escrito List[T]:
val fruit2: List[String] = List("apples", "oranges", "pears");System.out.println("""fruit2  : List[String] = """ + $show(fruit2 ));$skip(40); 
val nums2: List[Int] = List(1, 2, 3, 4);System.out.println("""nums2  : List[Int] = """ + $show(nums2 ));$skip(80); 
val diag32: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1));System.out.println("""diag32  : List[List[Int]] = """ + $show(diag32 ));$skip(35); 
val empty2: List[Nothing] = List();System.out.println("""empty2  : List[Nothing] = """ + $show(empty2 ));$skip(226); 

//Las listas se construyen de listas vacias Nil
//y la operacion de construccion x :: xs que da una nueva lista con el
//primer elemento x, seguido de los elementos xs
val fruit3 = "apples" :: ("oranges" :: ("pears" :: Nil));System.out.println("""fruit3  : List[String] = """ + $show(fruit3 ));$skip(42); 
val nums3 = 1 :: (2 :: (3 :: (4 :: Nil)));System.out.println("""nums3  : List[Int] = """ + $show(nums3 ));$skip(17); 
val empty3 = Nil;System.out.println("""empty3  : scala.collection.immutable.Nil.type = """ + $show(empty3 ));$skip(105); 

//La asociacion correcta es emitiendo los parentesis, por lo tanto:
val nums4 = 1 :: 2 :: 3 :: 4 :: Nil;System.out.println("""nums4  : List[Int] = """ + $show(nums4 ));$skip(248); 

nums match {
	//Lista de entero que empieza con 1 y sigue con 2
  case 1 :: 2 :: xs =>
  //  Lista con solo 1 de largo
  case x :: Nil =>
  // Lista que tiene `x :: Nil`
  case List(x) =>
  // Lista vacia, también llamada `Nil`
  case List() =>
};$skip(242); 
//MANERA DE ORDENAR LA LISTA ASCENDENTEMENTE
//def insertionSort(xs: List[Int]): List[Int] = xs match {
  //case List() => List()
  //case y :: ys => insert(y, insertionSort(ys))}

//Ejercicio
val cond: (Int, Int) => Boolean =
(x,y) => x < y;System.out.println("""cond  : (Int, Int) => Boolean = """ + $show(cond ));$skip(179); 

def insert(x: Int, xs: List[Int]): List[Int] =
  xs match {
    case List() => x ::
Nil

    case y :: ys =>
      if (cond(x, y)) x :: y :: ys
      else y :: insert(x, ys)
  };System.out.println("""insert: (x: Int, xs: List[Int])List[Int]""");$skip(320); val res$0 = 
//insert(2, 1 :: 3 :: Nil) shouldBe (1 :: 2 :: 3 :: Nil)
//insert(1, 2 :: 3 :: Nil) shouldBe (1 :: 2 :: 3 :: Nil)
//insert(3, 1 :: 2 :: Nil) shouldBe (1 :: 2 :: 3 :: Nil)


//El mapeo esa la iteracion que le mandes, en este ejemplo a todos los Int de la lista
//les suma 1
List(1, 2, 3).map(x => x + 1) == List(2, 3, 4);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(128); val res$1 = 

//El filter filtra los elementos a travez de lo que le pongas en la iteracion
List(1, 2, 3).filter(x => x % 2 == 0) == List(2);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(151); 

//el flatMap Igual que los anteriores, pero te los aplana en la lista (seguido)
val xs =
  List(1, 2, 3).flatMap { x =>
    List(x, 2 * x, 3 * x)
  };System.out.println("""xs  : List[Int] = """ + $show(xs ));$skip(38); val res$2 = 
xs == List(1, 2, 3, 2, 4, 6, 3, 6, 9);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(1680); 

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
 	def triple(x: Int): Int = 3 * x;System.out.println("""triple: (x: Int)Int""");$skip(87); 

def tripleEither(x: Either[String, Int]): Either[String, Int] =
  x.right.map(triple);System.out.println("""tripleEither: (x: Either[String,Int])Either[String,Int]""");$skip(28); val res$3 = 
 	 
 tripleEither(Right(1));System.out.println("""res3: Either[String,Int] = """ + $show(res$3));$skip(36); val res$4 = 
 tripleEither(Left("not a number"));System.out.println("""res4: Either[String,Int] = """ + $show(res$4))}
}
