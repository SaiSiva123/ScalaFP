/**
  * Created by bselvaraj
  */

import scala.util.Random._


object Options extends App {

  /*
    Option has two side Some , None
    Option[Some[A], None]
   */

    case class Emp(name : String, address : String, phone : Option[Int])

    val listOfEmployeeWithPhoneNumbers = (1 to 10 toList).map(x => Emp.apply("Hello"+ x,"Cupertino"+x ,Some((nextInt(1000000)))))

    val listOfEmployeeWithNoPhoneNumbers = (1 to 10 toList).map(x => Emp.apply("World"+ x,"SF"+x ,None))

    val employees = listOfEmployeeWithPhoneNumbers ::: listOfEmployeeWithNoPhoneNumbers

    println("AllEmplyees " +  employees)
    println("employee with phones" + employees.filter(_.phone.isDefined))

    //Can be composed with map
   println("employee " + employees.filter(_.name.endsWith("1")).map(_.phone.map(_+1000)))


  //Options is also Monad , Can be composed with FlatMap /Foreach expression

  val result = for{
    a <- Some(10)
    b <- Some(20)
  } yield (a + b )

  println(result.getOrElse(-1))
}
