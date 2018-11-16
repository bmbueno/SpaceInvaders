package Model

import javax.swing.{ImageIcon}

class Nave(coordX: Int, coordY: Int) extends Personagem(coordX,coordY){

  def getImgNave = Constantes.IMG_NAVE
  def moveTras(): Unit = {
    this.y = this.y - 10
  }

}
