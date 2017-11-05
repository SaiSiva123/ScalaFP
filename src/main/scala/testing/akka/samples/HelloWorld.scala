package testing.akka.samples

/**
  * Created by bselvaraj on 11/3/17.
  */

import akka.actor.{ ActorRef, ActorSystem, Props, Actor }
import scala.concurrent.duration._

// Define Actor Messages
case class SendMsg(who: String)

// Define Greeter Actor
class Receiver extends Actor {
  def receive = {
    case SendMsg(who) => println(s"Hello $who")
  }
}

object HelloAkkaScala extends App {

  // Create the 'hello akka' actor system
  val system = ActorSystem("HelloWorld")

  // Create the 'greeter' actor
  val sender = system.actorOf(Props[Receiver], "greeter")

  // Send WhoToGreet Message to actor
  sender ! SendMsg("Akka")

  //shutdown actorsystem
  system.terminate()

}