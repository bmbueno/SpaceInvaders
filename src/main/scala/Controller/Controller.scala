package Controller
import Model._

class Controller(){

  private var tecla: Int = 0
  private var velocidadeDefinida: Int = 0
  private var velocidade: Int = 0
  private var alien = new Alien(500,100)
  private var nave = new Nave(100,500)
  private var disparoNave: Disparo = new Disparo(200,200)

  def setVelocidade(novaVelocidade: Int): Unit = {
    this.velocidade = novaVelocidade
  }

  def getVelocidade = velocidade
  def getNave = nave
  def getAlien = alien

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
  }

  def setTecla(tecla: Int): Unit = {
    this.tecla = tecla
  }

  def Nave(): Unit = {
    this.tecla match {
        case 32 => {
            //adc disparo na lista de disparos
        }
        case 37 => {
          if(this.nave.getX > 0)
          nave.moveEsquerda()
        }
        case 39 => {
          if(this.nave.getX < 500)
          nave.moveDireita()
        }
        case 40 => {
          if(this.nave.getY < 500)
          nave.moveFrente()
        }
        case 38 => {
          if(this.nave.getY > 300)
          nave.moveTras()
        }
        case _ => // default
    }
  }

  def Alien(): Unit = { // vai ter de receber a lista de aliens
    if (this.velocidade == velocidadeDefinida * 1)
      this.alien.moveEsquerda()
    else if (this.velocidade == velocidadeDefinida * 2)
      this.alien.moveDireita()
    else if (this.velocidade > velocidadeDefinida * 3)
      this.velocidade = velocidadeDefinida
    this.velocidade = this.velocidade + 1
  }

  def disparos(): Unit = {
    this.disparoNave.moveFrente()
  }
}
