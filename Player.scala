package com.dev.akka

import akka.actor._

object Player {
    def p1 = Props(new Player("p1", "x"))
    def p2 = Props(new Player("p2", "y"))
    
    case class Play()
}


class Player(n:String, t:String) extends Actor {
  val name:String = n
  val token:String = t
  var pos:Int = 0
  val gameEngine = context.actorOf(RacingGame.props)
  
  override def receive: Receive = {
    case s:String => println(s)   
    case Player.Play() => { pos +=1; if(pos==20) gameEngine ! RacingGame.DeclareWinner(this)}
  }
  
}