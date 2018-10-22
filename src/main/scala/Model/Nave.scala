package Model

class Nave(simboloPersonagem: String, coordX: Int, coordY: Int)
  extends Personagem(simboloPersonagem, coordX, coordY){

  def moveParaFrente(): Unit ={
    this.setCoordenadaY(this.getCoordenadaY() - 1);
  }

  def moveParaTras(): Unit ={
    this.setCoordenadaY(this.getCoordenadaY() + 1);
  }

  def moveParaEsquerda(): Unit ={
    this.setCoordenadaX(this.getCoordenadaX() - 1);
  }

  def moveParaDireita(): Unit ={
    this.setCoordenadaX(this.getCoordenadaX() + 1);
  }
}
