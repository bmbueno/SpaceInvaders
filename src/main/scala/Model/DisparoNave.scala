package Model

class DisparoNave(simbolo: String, personagem:Nave)
  extends Personagem (simbolo, personagem.getCoordenadaX(), personagem.getCoordenadaY() - 1){
  private val distanciaPorCiclo: Int = 1;
  private val cicloNave: Int = 1;


  def getCicloDisparo(): Int = {
    return this.cicloNave;
  }

  def movimentoDisparo: Unit ={
    this.setCoordenadaY(this.getCoordenadaY() - this.distanciaPorCiclo);
  }



}
