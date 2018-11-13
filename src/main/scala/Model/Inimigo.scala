package Model
import View.{Interface}
import scala.collection.mutable.ListBuffer

class Inimigo(simbolo: String, coordX: Int, coordY: Int)
  extends Personagem (simbolo, coordX, coordY){

  var distancia: Int = 5
  def moveParaEsquerda(): Unit ={
    this.setCoordenadaX(this.getCoordenadaX() - 1);
  }
  def moveParaDireita(): Unit ={
    this.setCoordenadaX(this.getCoordenadaX() + 1);
  }
  def ondaInimigos(interface: Interface, quantidadeInimigos: Int = 1): ListBuffer[Inimigo] = {
    var vetorInimigos: ListBuffer[Inimigo] = new ListBuffer[Inimigo]

    for(i <- 1 to quantidadeInimigos){
      vetorInimigos += new Inimigo(simbolo,coordX + distancia,coordY)
      distancia += 20
    }
    for(inimigo <- vetorInimigos){
      inimigo.coordenadaX += distancia
    }
    return vetorInimigos

}
}
