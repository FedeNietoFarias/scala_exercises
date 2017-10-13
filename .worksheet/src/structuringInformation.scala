object structuringInformation {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(75); 
  println("Welcome to the Scala worksheet")
  case class Note(
  name: String,
  duration: String,
  octave: Int
  
);$skip(107); 
val c3 = Note("C", "Quarter", 3)


sealed trait Symbol
case class Note1(name: String, duration: String, octave: Int) extends Symbol
case class Rest(duration: String) extends Symbol;System.out.println("""c3  : structuringInformation.Note = """ + $show(c3 ));$skip(195); 
val symbol1: Symbol = Note1("C", "Quarter", 3);System.out.println("""symbol1  : structuringInformation.Symbol = """ + $show(symbol1 ));$skip(36); 
val symbol2: Symbol = Rest("Whole");System.out.println("""symbol2  : structuringInformation.Symbol = """ + $show(symbol2 ));$skip(206); 

def symbolDuration(symbol: Symbol): String =
  symbol match {
    case Note1(name, duration, octave) => duration
    case Rest(duration) => duration
    //Evalua la expresion a la derecha de la flecha
  };System.out.println("""symbolDuration: (symbol: structuringInformation.Symbol)String""");$skip(305); 
  
  def unexhaustive(): Unit = {
  sealed trait Symbol
  case class Note(name: String, duration: String, octave: Int) extends Symbol
  case class Rest(duration: String) extends Symbol

  def nonExhaustiveDuration(symbol: Symbol): String =
    symbol match {
      case Rest(duration) => duration
    }
}
//No manejamos todos los casos en non


case class Note2(name: String, duration: String, octave: Int);System.out.println("""unexhaustive: ()Unit""");$skip(136); 
val c4 = Note2("C", "Quarter", 3);System.out.println("""c4  : structuringInformation.Note2 = """ + $show(c4 ));$skip(39); 
val otherC4 = Note2("C", "Quarter", 3);System.out.println("""otherC4  : structuringInformation.Note2 = """ + $show(otherC4 ));$skip(33); 
val f3 = Note("F", "Quarter", 3);System.out.println("""f3  : structuringInformation.Note = """ + $show(f3 ));$skip(16); val res$0 = 
(c4 == otherC4);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(11); val res$1 = 
(c3 == f3)

//En el segundo da false, porque cambia el valor del name

sealed trait Duration
case object Whole extends Duration
case object Half extends Duration
case object Quarter extends Duration;System.out.println("""res1: Boolean = """ + $show(res$1));$skip(351); 

//Ejercicio final
def fractionOfWhole(duration: Duration): Double =
  duration match {
    case Whole => 1.0
    case Half =>  0.5
    case Quarter =>  0.25

  };System.out.println("""fractionOfWhole: (duration: structuringInformation.Duration)Double""")}

}
