object structuringInformation {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  case class Note(
  name: String,
  duration: String,
  octave: Int
  
)
val c3 = Note("C", "Quarter", 3)


sealed trait Symbol
case class Note1(name: String, duration: String, octave: Int) extends Symbol
case class Rest(duration: String) extends Symbol
val symbol1: Symbol = Note1("C", "Quarter", 3)
val symbol2: Symbol = Rest("Whole")

def symbolDuration(symbol: Symbol): String =
  symbol match {
    case Note1(name, duration, octave) => duration
    case Rest(duration) => duration
    //Evalua la expresion a la derecha de la flecha
  }
  
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


case class Note2(name: String, duration: String, octave: Int)
val c4 = Note2("C", "Quarter", 3)
val otherC4 = Note2("C", "Quarter", 3)
val f3 = Note("F", "Quarter", 3)
(c4 == otherC4)
(c3 == f3)

//En el segundo da false, porque cambia el valor del name

sealed trait Duration
case object Whole extends Duration
case object Half extends Duration
case object Quarter extends Duration

//Ejercicio final
def fractionOfWhole(duration: Duration): Double =
  duration match {
    case Whole => 1.0
    case Half =>  0.5
    case Quarter =>  0.25

  }

}