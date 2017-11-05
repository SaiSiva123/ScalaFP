/**
  * Created by bselvaraj on 11/5/17.
  */

import scala.util.{Failure, Success, Try}

object Trys extends App {

  /*
      expresss exceptions in Try Monads
      Try can Success or Failure
      Failure is part Throwable
      Success with be part Normal State
      Try is Monad , Can be compose flatMap Opertion using foreach expression
      Can be composed with map filter opertions

   */

  val validNumber = isValidNumber("Hello") match {
    case Success(validNumber) => validNumber
    case Failure(e) => println(e.getMessage); -1;

  }

  // Defalut when Exception occurs
  println(isValidNumber("Hello").getOrElse(-1))
  println(isValidNumber("10").getOrElse(-1))

  //Can run map if success
  println(isValidNumber("10").map(_ * 3).map(_ + 10).get)

  //Success or Failure
  val result = for {
    a <- isValidNumber("10")
    b <- isValidNumber("100")
    c <- isValidNumber("1000")
  } yield (a + b + c)
  println(validNumber)

  //Try is Monad , Can be be composable with flatMap operations

  def isValidNumber(number: String): Try[Int] = {
    Try {
      number.toInt
    }
  }

  println(result)


}
