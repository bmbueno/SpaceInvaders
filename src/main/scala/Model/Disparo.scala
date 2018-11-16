package Model

import javax.swing.{ImageIcon}

class Disparo(coordX: Int, coordY: Int, ativo1: Boolean = true){
  protected var x: Int = coordX
  protected var y: Int = coordY
  protected var velocidade: Int = 1
  var ativo: Boolean = ativo1

  private var imgDisparo: ImageIcon = new ImageIcon(System.getProperty("user.dir") + "/src/main/scala/View/disparo.jpeg")
  imgDisparo.setImage(imgDisparo.getImage().getScaledInstance(10,20,10))

  def getImgDisparo = imgDisparo

  def moveFrente(): Unit = {
    this.y = this.y - 10
  }

  def getX = x
  def getY = y
  def getAtivo = ativo

  def set(x: Int, y: Int,ativo: Boolean){
    this.x = x
    this.y = y
    this.ativo = ativo
  }
  def desativa(): Unit = {
    this.ativo = false
  }
}
