package Model

import javax.swing.{ImageIcon}

class Disparo(coordX: Int, coordY: Int, ativo1: Boolean = true) extends Personagem(coordX,coordY,ativo1){

  def getImgDisparo = Constantes.IMG_DISPARO

  def moveFrente(): Unit = {
    this.y = this.y - 10
  }
  def moveTras(): Unit = {
    this.y = this.y + 10
}
}
