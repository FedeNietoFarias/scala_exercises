object tailRecursion {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def gcd(a: Int, b: Int): Int =
  if (b == 0) a else gcd(b, a % b)                //> gcd: (a: Int, b: Int)Int
  gcd(14, 21)                                     //> res0: Int = 7
  
//Evaluacion en Scala
if (21 == 0) 14 else gcd(21, 14 % 21)             //> res1: Int = 7
if (false) 14 else gcd(21, 14 % 21)               //> res2: Int = 7
gcd(21, 14 % 21)                                  //> res3: Int = 7
gcd(21, 14)                                       //> res4: Int = 7
if (14 == 0) 21 else gcd(14, 21 % 14)             //> res5: Int = 7
if (false) 21 else gcd(14, 21 % 14)               //> res6: Int = 7
gcd(14, 7)                                        //> res7: Int = 7
gcd(7, 14 % 7)                                    //> res8: Int = 7
gcd(7, 0)                                         //> res9: Int = 7
if (0 == 0) 7 else gcd(0, 7 % 0)                  //> res10: Int = 7
if (true) 7 else gcd(0, 7 % 0)                    //> res11: Int = 7
7                                                 //> res12: Int(7) = 7


//FACTORIAL
def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)         //> factorial: (n: Int)Int
  factorial(4)                                    //> res13: Int = 24
if (4 == 0)
1
//Evaluacion en Scala
else 4 * factorial(4 - 1)                         //> res14: Int = 24
4 * factorial(3)                                  //> res15: Int = 24
4 * (3 * factorial(2))                            //> res16: Int = 24
4 * (3 * (2 * factorial(1)))                      //> res17: Int = 24
4 * (3 * (2 * (1 * factorial(0))))                //> res18: Int = 24
4 * (3 * (2 * (1 * 1)))                           //> res19: Int = 24
24                                                //> res20: Int(24) = 24

//Diferencia entre las 2 secuencias:
//En el caso de gcd: RECURSIVA DE LA COLA(tail recursion) va de una llamada a la siguiente y termina.
//En el caso factorial:NO RECURSIVA DE LA COLA(tail recursion)
//										Tenemos que ir añadiendo un elemento mas a nuestras expresiones hasta el valor final.
//@tailrec sirve para definir un tail recursion a la funcion actual

def factorial2 (n: Int): Int = {
  
  def iter(x: Int, result: Int): Int =
    if (x ==0 ) result
    else iter(x -1, result * x)

  iter(n,1)
}                                                 //> factorial2: (n: Int)Int

}