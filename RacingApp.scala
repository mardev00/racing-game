package com.dev.akka

import akka.actor._
import akka._

object RacingApp extends App {
  val system = actor.ActorSystem("game")
  val p1 = system.actorOf(Player.p1, "p1")
  val p2 = system.actorOf(Player.p2, "p2")
  
  
  
  val gameEngine:ActorRef = system.actorOf(RacingGame.props, "racing-game")
  gameEngine ! "test"
  while(true) {
    p1 ! Player.Play()
    p2 ! Player.Play()
  }
    
}