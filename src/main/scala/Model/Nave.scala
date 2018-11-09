package Model

import javax.swing.ImageIcon

class Nave(simboloPersonagem: String, coordX: Int, coordY: Int)
  extends Personagem(simboloPersonagem, coordX, coordY) {

  def moveParaFrente(): Unit ={
    this.setCoordenadaY(this.getCoordenadaY() - 10);
  }

  def moveParaTras(): Unit ={
    this.setCoordenadaY(this.getCoordenadaY() + 10);
  }

  def moveParaEsquerda(): Unit ={
    this.setCoordenadaX(this.getCoordenadaX() - 10);
  }

  def moveParaDireita(): Unit ={
    this.setCoordenadaX(this.getCoordenadaX() + 10);
  }
  def moveuNave(tecla: Int,width:Int, height:Int): Unit = {
    tecla match {
        case 37 => {
          if(this.coordenadaX > 0)
          moveParaEsquerda()
        }
        case 39 => {
          if(this.coordenadaX != width - 10)
          moveParaDireita()
        }
        case 38 => {
          if(this.coordenadaY > 0)
          moveParaFrente()
        }
        case 40 => {
          if(this.coordenadaY != height - 10)
          moveParaTras()
        }
        case _ => // default
    }
}
  def naveImg(): ImageIcon = {
    return new ImageIcon("nave.jpg")
  }
}
