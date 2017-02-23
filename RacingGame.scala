package com.dev.akka

import akka.actor._
import akka._

object RacingGame {
  def props = Props(new RacingGame)
  case class StartGame()
  case class DeclareWinner(p:Player)
  
}

class RacingGame extends Actor {
  
  override def receive: Receive = {  
    case RacingGame.StartGame => drawBoard
    case RacingGame.DeclareWinner(p) => { println("\nWINNER IS: " + p.name); System.exit(0) }
  }
  
  def drawBoard() {
    
  }
  
  def checkStatus() {
    
  }
  
}
