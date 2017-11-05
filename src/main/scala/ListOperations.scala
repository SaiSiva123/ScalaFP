/**
  * Created by bselvaraj on 11/4/17.
  */
object ListOperations extends App {

  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }

    //Last but one buildIn
  def penultimateBuiltin[A](list : List[A]) : A = {
    list.init.last
  }

  //Last but one recursion
  def penultimate[A](list : List[A]) : A = list match {
    case h :: t :: Nil => h
    case h :: tail => penultimate(tail)
    case _ => throw new NoSuchElementException;
  }

  //last buildIn
  def last[A](list : List[A]) = list.last

  //last recursive

  def lastRecursive[A](list : List[A]) : A = list match {
    case h :: Nil => h
    case _ :: tail => lastRecursive(tail)
    case _ => throw new NoSuchElementException
  }

  //Nth eleement buildin
  def findNthElementInList[A] (n :Int,list : List[A] ) : A ={
    if( n < list.length) list(n) else throw new NoSuchElementException;
  }

  //Nth eleement recursion

  def findNth[A](n : Int, list: List[A]):A =  (n, list) match {
    case (0, h :: _ ) => h
    case (n , h :: tail) => findNth(n-1,tail)
    case _ => throw new NoSuchElementException
  }

  //Palindrome List
  def isPalindrome[A](list: List[A]) : Boolean ={
    list == list.reverse
  }



}
