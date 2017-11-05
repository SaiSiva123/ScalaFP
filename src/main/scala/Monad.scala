

/**
  * Created by bselvaraj
  */
object Monoid extends App {

  import Monoid._
  def sum(list: List[Int]) = list.foldLeft(IntMonoid.zero)(IntMonoid.map)

  def concat(list: List[String]) = list.foldLeft(StringMonoid.zero)(StringMonoid.map)

  trait Monoid[A] {
    def map(a1: A, a2: A): A

    def zero: A
  }

  object Monoid {

    implicit val IntMonoid: Monoid[Int] = new Monoid[Int] {
      def map(a: Int, b: Int): Int = a + b

      def zero: Int = 0
    }

    implicit val StringMonoid: Monoid[String] = new Monoid[String] {
      def map(a: String, b: String): String = a + b

      def zero: String = ""
    }

    implicit val listMoniod: Monoid[List[Int]] = new Monoid[List[Int]] {
      def map(a: List[Int], b: List[Int]): List[Int] = a ::: b

      def zero: List[Int] = Nil
    }

  }

  println(sum(1 to 10 toList))
  println(concat(List("hello", "world")))

}
