/**
  * Created by bselvaraj on 10/2/17.
  */

object ReverseList  extends App {

  def reverse[A](list : List[A]) : List[A] = list.reverse

  def reverseRecur[A] (list : List[A]) : List[A] = list match{
    case Nil => Nil
    case h :: tail => reverseRecur(tail) ::: List(h)
  }

  def reverseTailRecur[A] (list : List[A]) : List[A] = {

    def reverse[A](list :List[A],acc : List[A]) : List[A] =  list match{
      case Nil => acc
      case h :: tail => reverse(tail, h :: acc)
    }
    reverse(list,Nil)
  }

  def foldReverse[A](list : List[A]): List[A] ={
    list.foldLeft(List[A]())((r, h ) => (h :: r))
  }

  def reverseWords(line : String) = {
    line.split(" ").toList.reverse.mkString(" ")
  }

    println(reverse (1 to 10 toList))
    println(reverseRecur(1 to 100 toList))
    println(reverseTailRecur(1 to 10 toList))
    println(foldReverse(1 to 10 toList))


}
