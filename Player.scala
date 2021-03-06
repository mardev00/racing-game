package com.dev.akka

import akka.actor._
import akka._

object Player {
    def p1 = Props(new Player("p1", "p1"))
    def p2 = Props(new Player("p2", "p2"))
   
    case class Play()
}


class Player(n:String, t:String) extends Actor {
  val name:String = n
  val token:String = t
  var pos:Int = 0
  val gameEngine = context.actorOf(RacingGame.props)
  
  override def receive: Receive = {
    
    case s:String => println(s)   
    case Player.Play() => {Thread.sleep(scala.util.Random.nextInt(10));  pos +=1; print(" " + token); if(pos==20) gameEngine ! RacingGame.DeclareWinner(this)}
  }
  
}