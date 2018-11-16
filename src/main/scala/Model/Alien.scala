package Model

import javax.swing.{ImageIcon}

class Alien(coordX: Int, coordY: Int) extends Disparo(coordX,coordY){

  private var imgAlien: ImageIcon = new ImageIcon(System.getProperty("user.dir") + "/src/main/scala/View/alien.gif")
  imgAlien.setImage(imgAlien.getImage().getScaledInstance(50,50,10))

  private var imgAlien1: ImageIcon = new ImageIcon(System.getProperty("user.dir") + "/src/main/scala/View/alien.gif")
  imgAlien1.setImage(imgAlien1.getImage().getScaledInstance(50,50,10))

  private var imgAlien2: ImageIcon = new ImageIcon(System.getProperty("user.dir") + "/src/main/scala/View/alien.gif")
  imgAlien2.setImage(imgAlien2.getImage().getScaledInstance(50,50,10))

  def getImgAlien = imgAlien
  def getImgAlien1 = imgAlien1
  def getImgAlien2 = imgAlien2

  def moveDireita(): Unit = {
    this.x = this.x + 10
  }
  def moveEsquerda(): Unit = {
    this.x = this.x - 10
  }
}
