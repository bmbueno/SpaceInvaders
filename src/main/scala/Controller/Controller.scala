package Controller
import Model._
import scala.Array._
import Array._

class Controller(){

  private val numeroAliens: Int = 11
  private var tecla: Int = 0
  private var velocidadeDefinida: Int = 0
  private var velocidade: Int = 0
  private var alien = new Alien(10,100)
  private var nave = new Nave(100,500)
  private var disparoNave: Disparo = new Disparo(200,200,false)
  private var aliens: Array[Alien] = new Array[Alien](numeroAliens)
  private var aliens1: Array[Alien] = new Array[Alien](numeroAliens)
  private var aliens2: Array[Alien] = new Array[Alien](numeroAliens)
  private var pontuacao: Int = 0

  def getVelocidade = velocidade
  def getNave = nave
  def getAlien = alien
  def getDisparo = disparoNave
  def getNumAliens = numeroAliens
  def getPontuação = pontuacao

  def inicializaAliens(): Unit = {
    for(i <- 0 to numeroAliens-1){
      aliens(i) = new Alien(5+((i)*50),30)
    }
    for(i <- 0 to numeroAliens-1){
      aliens1(i) = new Alien(5+((i)*50),70)

    }
    for(i <- 0 to numeroAliens-1){
      aliens2(i) = new Alien(5+((i)*50),110)
    }

  }

  def setDificuldade(dificuldade: String): Unit = {
    dificuldade match {
      case "Facil" => {
        this.velocidadeDefinida = 400
      }
      case "Medio" =>{
        this.velocidadeDefinida = 200
      }
      case "Dificil" =>{
        this.velocidadeDefinida = 100
      }
    }
    this.velocidade = velocidadeDefinida
  }

  def setTecla(tecla: Int): Unit = {
    this.tecla = tecla
  }

  def Nave(): Unit = {
    this.tecla match {
        case 32 => {
            disparoNave.set(nave.getX,nave.getY,true)
        }
        case 37 => {
          if(this.nave.getX > 0)
          nave.moveEsquerda()
        }
        case 39 => {
          if(this.nave.getX < 500)
          nave.moveDireita()
        }
        // case 40 => {
        //   if(this.nave.getY < 500)
        //   nave.moveFrente()
        // }
        // case 38 => {
        //   if(this.nave.getY > 300)
        //   nave.moveTras()
        // }
        case _ => // default
    }
  }

  def Alien(): Unit = { // vai ter de receber a lista de aliens
    if (this.velocidade == velocidadeDefinida + 10){
      for(i <- 0 to numeroAliens-1){
        this.aliens(i).moveEsquerda()
        this.aliens(i).moveEsquerda()
        this.aliens1(i).moveDireita()
        this.aliens1(i).moveDireita()
        this.aliens2(i).moveEsquerda()
        this.aliens2(i).moveEsquerda()
      }
  }
     else if (this.velocidade == velocidadeDefinida + 20){
       for(i <- 0 to numeroAliens-1){
         this.aliens(i).moveDireita()
         this.aliens(i).moveDireita()
         this.aliens1(i).moveEsquerda()
         this.aliens1(i).moveEsquerda()
         this.aliens2(i).moveDireita()
         this.aliens2(i).moveDireita()
       }
     }
     else if (this.velocidade > velocidadeDefinida + 30)
       this.velocidade = velocidadeDefinida
     this.velocidade = this.velocidade + 1

  }

  def disparos(): Unit = {
    if(this.disparoNave.getAtivo){
      this.disparoNave.moveFrente()
    }
    for(i <- 0 to numeroAliens-1){
      if(((this.disparoNave.getX > aliens(i).getX - 10) && (this.disparoNave.getX < aliens(i).getX + 10)) && (this.disparoNave.getY == aliens(i).getY))
      {  this.disparoNave.desativa()
        this.aliens(i).desativa()
        pontuacao += 30
  }
      if(((this.disparoNave.getX > aliens1(i).getX - 10) && (this.disparoNave.getX < aliens1(i).getX + 10)) && (this.disparoNave.getY == aliens1(i).getY))
      {  this.disparoNave.desativa()
        this.aliens1(i).desativa()
        pontuacao += 20
  }
      if(((this.disparoNave.getX > aliens2(i).getX - 10) && (this.disparoNave.getX < aliens2(i).getX + 10)) && (this.disparoNave.getY == aliens2(i).getY))
      {  this.disparoNave.desativa()
        this.aliens2(i).desativa()
        pontuacao += 10
}
println(pontuacao)
}}
  def getAliens(i : Int): Alien = {
    return aliens(i)
  }
  def getAliens1(i : Int): Alien = {
    return aliens1(i)
  }
  def getAliens2(i : Int): Alien = {
    return aliens2(i)
  }

  def verificaColisao(): Unit = {

  }

}
