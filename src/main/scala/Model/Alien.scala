package Model

import javax.swing.{ImageIcon}

class Alien(coordX: Int, coordY: Int) extends Personagem(coordX,coordY){
  var disparo: Disparo = new Disparo(this.x,this.y,false)
  def getImgAlien = Constantes.IMG_ALIEN1
  def getImgAlien1 = Constantes.IMG_ALIEN2
  def getImgAlien2 = Constantes.IMG_ALIEN3

  def dispara(): Unit = {
    this.disparo.ativo = true
  }

}
