package Model

import javax.swing.{ImageIcon}

class Alien(coordX: Int, coordY: Int) extends Disparo(coordX,coordY){

  private var imgAlien: ImageIcon = new ImageIcon(System.getProperty("user.dir") + "/src/main/scala/View/alien.gif")
  imgAlien.setImage(imgAlien.getImage().getScaledInstance(50,50,10))

  def getImgAlien = imgAlien

  def moveDireita(): Unit = {
    this.x = this.x + 10
  }
  def moveEsquerda(): Unit = {
    this.x = this.x - 10
  }
}
