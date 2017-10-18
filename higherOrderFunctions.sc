object higherOrderFunctions {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def sumInts(a: Int, b: Int): Int =
  if (a > b) 0 else a + sumInts(a + 1, b)         //> sumInts: (a: Int, b: Int)Int
  //La suma de todos los enteros entre A y B
  
  def cube(x: Int): Int = x * x * x               //> cube: (x: Int)Int

def sumCubes(a: Int, b: Int): Int =
  if (a > b) 0 else cube(a) + sumCubes(a + 1, b)  //> sumCubes: (a: Int, b: Int)Int
  //La suma de los cubos entre A y B
  def factorial (x: Int): Int= x*x                //> factorial: (x: Int)Int
  //Como se debe resolver un factorial
  def sumFactorials(a: Int, b: Int): Int =
  if (a > b) 0 else factorial(a) + sumFactorials(a + 1, b)
                                                  //> sumFactorials: (a: Int, b: Int)Int
  
  def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum(f, a + 1, b)                    //> sum: (f: Int => Int, a: Int, b: Int)Int
  //Patron comun entre los tres anteriores
  def id(x: Int): Int = x                         //> id: (x: Int)Int
def sumInts2(a: Int, b: Int) = sum(id, a, b)      //> sumInts2: (a: Int, b: Int)Int
def sumCubes2(a: Int, b: Int) = sum(cube, a, b)   //> sumCubes2: (a: Int, b: Int)Int
def sumFactorials2(a: Int, b: Int) = sum(factorial, a, b)
                                                  //> sumFactorials2: (a: Int, b: Int)Int
//Se puede escribir de esta manera, usando patrones
  
 //Para no crear tantas funciones pequeñas cuando no hace falta por ejemplo
 //en vez de crear: val str="abc"; println(str)
 //podemos poner directo println("abc)
 //porque las cadenas existen como literales. Este tipo de funciones son llamadas
 //FUNCIONES ANONIMAS
 
 (x: Int) => x * x * x                            //> res0: Int => Int = higherOrderFunctions$$$Lambda$8/1456208737@1cd072a9
 //Funcion anonima que eleva su argumento al cubo
 
 (x: Int, y: Int) => x + y                        //> res1: (Int, Int) => Int = higherOrderFunctions$$$Lambda$9/2083562754@49e4cb
                                                  //| 85
 //Si hay varios parametros estan separados por coma
 
 //Usando funciones anonimas, podemos escribir sumas de una manera mas corta
 def sumInts3(a: Int, b: Int) = sum(x => x, a, b) //> sumInts3: (a: Int, b: Int)Int
def sumCube3(a: Int, b: Int) = sum(x => x * x * x, a, b)
                                                  //> sumCube3: (a: Int, b: Int)Int
 
 //Ejercicio
 def sum4(f: Int => Int, a: Int, b: Int): Int = {
  def loop(x: Int, acc: Int): Int = {
    if (x > b) acc
    else loop(x + 1, acc + f(x))
  }
  loop(a, 0)
}                                                 //> sum4: (f: Int => Int, a: Int, b: Int)Int
//sum4(x => x, 1, 10) shouldBe 55
 
}