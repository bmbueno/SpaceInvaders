package Model

class Nave(simboloPersonagem: String, coordX: Int, coordY: Int)
  extends Personagem(simboloPersonagem, coordX, coordY){

  def moveParaFrente(): Unit ={
    this.setCoordenadaY(this.getCoordenadaY() - 10);
  }

  def moveParaTras(): Unit ={
    this.setCoordenadaY(this.getCoordenadaY() + 10);
  }

  def moveParaEsquerda(): Unit ={
    this.setCoordenadaX(this.getCoordenadaX() - 10);
  }

  def moveParaDireita(): Unit ={
    this.setCoordenadaX(this.getCoordenadaX() + 10);
  }
  def moveu(): Unit = {
    //if(KeyEvent.VK_ENTER){
    //  println("foi")
    }



}
