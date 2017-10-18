object higherOrderFunctions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala worksheet");$skip(79); 
  def sumInts(a: Int, b: Int): Int =
  if (a > b) 0 else a + sumInts(a + 1, b);System.out.println("""sumInts: (a: Int, b: Int)Int""");$skip(84); 
  //La suma de todos los enteros entre A y B
  
  def cube(x: Int): Int = x * x * x;System.out.println("""cube: (x: Int)Int""");$skip(86); 

def sumCubes(a: Int, b: Int): Int =
  if (a > b) 0 else cube(a) + sumCubes(a + 1, b);System.out.println("""sumCubes: (a: Int, b: Int)Int""");$skip(72); 
  //La suma de los cubos entre A y B
  def factorial (x: Int): Int= x*x;System.out.println("""factorial: (x: Int)Int""");$skip(141); 
  //Como se debe resolver un factorial
  def sumFactorials(a: Int, b: Int): Int =
  if (a > b) 0 else factorial(a) + sumFactorials(a + 1, b);System.out.println("""sumFactorials: (a: Int, b: Int)Int""");$skip(97); 
  
  def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum(f, a + 1, b);System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(69); 
  //Patron comun entre los tres anteriores
  def id(x: Int): Int = x;System.out.println("""id: (x: Int)Int""");$skip(45); 
def sumInts2(a: Int, b: Int) = sum(id, a, b);System.out.println("""sumInts2: (a: Int, b: Int)Int""");$skip(48); 
def sumCubes2(a: Int, b: Int) = sum(cube, a, b);System.out.println("""sumCubes2: (a: Int, b: Int)Int""");$skip(58); 
def sumFactorials2(a: Int, b: Int) = sum(factorial, a, b);System.out.println("""sumFactorials2: (a: Int, b: Int)Int""");$skip(347); val res$0 = 
//Se puede escribir de esta manera, usando patrones
  
 //Para no crear tantas funciones pequeñas cuando no hace falta por ejemplo
 //en vez de crear: val str="abc"; println(str)
 //podemos poner directo println("abc)
 //porque las cadenas existen como literales. Este tipo de funciones son llamadas
 //FUNCIONES ANONIMAS
 
 (x: Int) => x * x * x;System.out.println("""res0: Int => Int = """ + $show(res$0));$skip(79); val res$1 = 
 //Funcion anonima que eleva su argumento al cubo
 
 (x: Int, y: Int) => x + y;System.out.println("""res1: (Int, Int) => Int = """ + $show(res$1));$skip(182); 
 //Si hay varios parametros estan separados por coma
 
 //Usando funciones anonimas, podemos escribir sumas de una manera mas corta
 def sumInts3(a: Int, b: Int) = sum(x => x, a, b);System.out.println("""sumInts3: (a: Int, b: Int)Int""");$skip(57); 
def sumCube3(a: Int, b: Int) = sum(x => x * x * x, a, b);System.out.println("""sumCube3: (a: Int, b: Int)Int""");$skip(174); 
 
 //Ejercicio
 def sum4(f: Int => Int, a: Int, b: Int): Int = {
  def loop(x: Int, acc: Int): Int = {
    if (x > b) acc
    else loop(x + 1, acc + f(x))
  }
  loop(a, 0)
};System.out.println("""sum4: (f: Int => Int, a: Int, b: Int)Int""")}
//sum4(x => x, 1, 10) shouldBe 55
 
}
