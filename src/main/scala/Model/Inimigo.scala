package Model

class Inimigo(simbolo: String, coordX: Int, coordY: Int)
  extends Personagem (simbolo, coordX, coordY){

  def moveParaEsquerda(): Unit ={
    this.setCoordenadaX(this.getCoordenadaX() - 1);
  }
  def moveParaDireita(): Unit ={
    this.setCoordenadaX(this.getCoordenadaX() + 1);
  }
}
