package Model

import javax.swing.{ImageIcon}

class Disparo(coordX: Int, coordY: Int, ativo: Boolean = true){
  protected var x: Int = coordX
  protected var y: Int = coordY
  protected var velocidade: Int = 1

  private var imgDisparo: ImageIcon = new ImageIcon(System.getProperty("user.dir") + "/src/main/scala/View/alien.gif")
  imgDisparo.setImage(imgDisparo.getImage().getScaledInstance(50,50,10))

  def getImgDisparo = imgDisparo

  def moveFrente(): Unit = {
    this.y = this.y + 10
  }

  def getX = x
  def getY = y
}
