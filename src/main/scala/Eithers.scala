import scala.util._

/**
  * Created by bselvaraj on 11/5/17.
  */


object Either extends App {
  /*

   Either
   Right will have normal condition
   Left will return unexception conditions
   Can be composed Flatmap,Map filter functional expressions
 */

  def isValidNumber(number : String) : Either[String,Int] = {
    Try{
      number.toInt
    }match {
      case Success(a) => Right(a)
      case Failure(ex) => Left("Not Valid Number")
    }
  }


  println(isValidNumber("1000"))
  println(isValidNumber("Hell"))

  //Can be compose with map
  println(isValidNumber("1000").map(r => r + 100).right)

  //Can be composed with flatMap Since Either is Monad in nature

  val result = for{
    a <- isValidNumber("100")
    b <- isValidNumber("200")
    c <- isValidNumber("200")
  } yield (a + b + c)

  println("result " + result.getOrElse(-1))



}
