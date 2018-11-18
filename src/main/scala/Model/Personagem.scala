package Model

class Personagem(coordX: Int, coordY: Int, ativo1: Boolean = true) {
  
  protected var x: Int = coordX
  protected var y: Int = coordY
  protected var velocidade: Int = 1
  var ativo: Boolean = ativo1

  def set(x: Int, y: Int,ativo: Boolean){
    this.x = x
    this.y = y
    this.ativo = ativo
  }
  def desativa(): Unit = {
    this.ativo = false
  }
  def getX = x
  def getY = y
  def getAtivo = ativo

  def moveDireita(): Unit = {
    this.x = this.x + 10
  }
  def moveEsquerda(): Unit = {
    this.x = this.x - 10
  }
}
