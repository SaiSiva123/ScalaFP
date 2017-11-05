package Functors


object FunctorExample extends App {


  /*

    Functors runs mapper functions on containers
    Accept functions which tranform A to B ( f : A =>B }
    Container { List[A])
    return Container[B]

   */

  trait Functor[Container[_]]{
      def fmap[A,B] (f: A => B) :Container[A]  => Container[B]
  }

  implicit object ListFunctor extends Functor[List]{
      def fmap[A,B] (f: A => B) : List[A] => List[B] = list => list map f
  }

  implicit object OptionFunctor extends Functor[Option] {
    def fmap[A,B] (f: A => B) : Option[A] => Option[B] = option => option map f
  }

  implicit def mapFunctions[Container[_],A](container :Container[A]) = new {
     def fmap[B](f: A =>B)(implicit functor: Functor[Container]): Container[B] ={
       functor.fmap(f)(container)
     }
  }

  //Accept List[int] => List[string]
  println( (1 to 10 toList) fmap("hello"+ _) )

  def someNumber : Option[Int]= Some(1)
  println(someNumber fmap (_ +1))


}
