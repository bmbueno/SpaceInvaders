package Model
import View.{Interface}
import javax.swing.JLabel;

class Personagem(simboloPersonagem: String, coordX: Int, coordY: Int) {
  private var simbolo: String = simboloPersonagem;
  private var coordenadaX: Int = coordX;
  private var coordenadaY: Int = coordY;
  private var label: JLabel = new JLabel();
  private val tamanho: Int = 10;

  def iniciaLabel():Unit = {
    this.label.setText(this.simbolo);
    this.label.setBounds(this.coordenadaX, this.coordenadaY, this.tamanho, this.tamanho);
  }

  def printPersonagem(interface : Interface): Unit = {
    this.iniciaLabel();
    interface.add(this.label);
  }

  def getCoordenadaX():Int = {
    return this.coordenadaX;
  }

  def getCoordenadaY():Int = {
    return this.coordenadaY;
  }

  def getLabel():JLabel = {
    return this.label;
  }

  def setCoordenadaX(coordX:Int): Unit ={
    this.coordenadaX = coordX;
  }

  def setCoordenadaY(coordY:Int): Unit ={
    this.coordenadaY = coordY;
  }

  def testeColisao(personagem:Personagem): Boolean = {
    var colisao: Boolean = false;
    if(this.coordenadaX == personagem.getCoordenadaX() && this.coordenadaY == personagem.getCoordenadaY()){
      colisao = true;
    }
    return colisao;
  }
}
