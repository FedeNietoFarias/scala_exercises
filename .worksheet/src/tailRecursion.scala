object tailRecursion {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(66); 
  println("Welcome to the Scala worksheet");$skip(68); 
  def gcd(a: Int, b: Int): Int =
  if (b == 0) a else gcd(b, a % b);System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(14); val res$0 = 
  gcd(14, 21);System.out.println("""res0: Int = """ + $show(res$0));$skip(63); val res$1 = 
  
//Evaluacion en Scala
if (21 == 0) 14 else gcd(21, 14 % 21);System.out.println("""res1: Int = """ + $show(res$1));$skip(36); val res$2 = 
if (false) 14 else gcd(21, 14 % 21);System.out.println("""res2: Int = """ + $show(res$2));$skip(17); val res$3 = 
gcd(21, 14 % 21);System.out.println("""res3: Int = """ + $show(res$3));$skip(12); val res$4 = 
gcd(21, 14);System.out.println("""res4: Int = """ + $show(res$4));$skip(38); val res$5 = 
if (14 == 0) 21 else gcd(14, 21 % 14);System.out.println("""res5: Int = """ + $show(res$5));$skip(36); val res$6 = 
if (false) 21 else gcd(14, 21 % 14);System.out.println("""res6: Int = """ + $show(res$6));$skip(11); val res$7 = 
gcd(14, 7);System.out.println("""res7: Int = """ + $show(res$7));$skip(15); val res$8 = 
gcd(7, 14 % 7);System.out.println("""res8: Int = """ + $show(res$8));$skip(10); val res$9 = 
gcd(7, 0);System.out.println("""res9: Int = """ + $show(res$9));$skip(33); val res$10 = 
if (0 == 0) 7 else gcd(0, 7 % 0);System.out.println("""res10: Int = """ + $show(res$10));$skip(31); val res$11 = 
if (true) 7 else gcd(0, 7 % 0);System.out.println("""res11: Int = """ + $show(res$11));$skip(2); val res$12 = 
7;System.out.println("""res12: Int(7) = """ + $show(res$12));$skip(85); 


//FACTORIAL
def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1);System.out.println("""factorial: (n: Int)Int""");$skip(15); val res$13 = 
  factorial(4);System.out.println("""res13: Int = """ + $show(res$13));$skip(62); val res$14 = 
if (4 == 0)
1
//Evaluacion en Scala
else 4 * factorial(4 - 1);System.out.println("""res14: Int = """ + $show(res$14));$skip(17); val res$15 = 
4 * factorial(3);System.out.println("""res15: Int = """ + $show(res$15));$skip(23); val res$16 = 
4 * (3 * factorial(2));System.out.println("""res16: Int = """ + $show(res$16));$skip(29); val res$17 = 
4 * (3 * (2 * factorial(1)));System.out.println("""res17: Int = """ + $show(res$17));$skip(35); val res$18 = 
4 * (3 * (2 * (1 * factorial(0))));System.out.println("""res18: Int = """ + $show(res$18));$skip(24); val res$19 = 
4 * (3 * (2 * (1 * 1)));System.out.println("""res19: Int = """ + $show(res$19));$skip(3); val res$20 = 
24;System.out.println("""res20: Int(24) = """ + $show(res$20));$skip(515); 

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
};System.out.println("""factorial2: (n: Int)Int""")}

}
