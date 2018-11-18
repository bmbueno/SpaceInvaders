package Controller
import Model._
import scala.Array._
import Array.ofDim
import scala.util.Random

class Controller() extends Thread{

  private var tecla: Int = 0
  private var velocidadeDefinida: Int = 0
  private var velocidade: Int = 0
  private var alien = new Alien(10,100)
  private var nave = new Nave(100,500)
  private var disparoNave: Disparo = new Disparo(100,200,false)
  private var aliensV =  ofDim[Alien](3,Constantes.NUMERO_ALIENS_LINHA)
  private var pontuacao: Int = 0
  private var iRandomico : Random = new Random
  private var jRandomico : Random = new Random
  private var vida: Int = 3
  private var aliensMortos: Int = 0


  def getVelocidade = velocidade
  def getNave = nave
  def getAlien = alien
  def getDisparo = disparoNave
  def getNumAliens = Constantes.NUMERO_ALIENS_LINHA
  def getNumAliensColuna = Constantes.NUMERO_ALIENS_COLUNA
  def getPontuação = pontuacao
  def getImagemAlien1 = Constantes.IMG_ALIEN1
  def getImagemDisparo = Constantes.IMG_DISPARO
  def getVida = vida

  //********* INICIALIZA A MATRIZ DE ALIENS COM AS DEVIDAS POSIÇÕES NA TELA
  def inicializa(): Unit = {
    for(i <- 0 to Constantes.NUMERO_ALIENS_COLUNA-1){
      for(j <- 0 to Constantes.NUMERO_ALIENS_LINHA-1){
        aliensV(i)(j) = new Alien(5+((j)*50),(30 + (i*40)))
      }
    }
    vida = 3
  }
  //***********************************************************************************************
  def setDificuldade(dificuldade: String): Unit = {
    dificuldade match {
      case "Facil" => {
        this.velocidadeDefinida = Constantes.VELOCIDADE_ALIEN_FACIL
      }
      case "Medio" =>{
        this.velocidadeDefinida = Constantes.VELOCIDADE_ALIEN_MEDIO
      }
      case "Dificil" =>{
        this.velocidadeDefinida = Constantes.VELOCIDADE_ALIEN_DIFICIL
      }
    }
    this.velocidade = velocidadeDefinida
  }

  def setTecla(tecla: Int): Unit = {
    this.tecla = tecla
  }

  //************ PEGA A TECLA DADA PELA INTERFACE PARA MOVIMENTAR A NAVE
  def Nave(): Unit = {
    this.tecla match {
        case 32 => {
            if(!disparoNave.getAtivo)
              disparoNave.set(nave.getX,nave.getY,true)
        }
        case 37 => {
          if(this.nave.getX > 0)
          nave.moveEsquerda()
        }
        case 39 => {
          if(this.nave.getX < 500)
          nave.moveDireita()
        }
        case _ => // default
    }
  }

  //***********************************************************************************
  // CONTROLA A MOVIMENTAÇÃO DOS ALIENS
  override def run(): Unit = {
    try {
      if (this.velocidade == velocidadeDefinida ){
        for(i <- 0 to Constantes.NUMERO_ALIENS_COLUNA-1){           // <= VARIA CONFORME VELOCIDADE DEFINIDA, INVERTENDO O MOVIMENTO
          for(j <- 0 to Constantes.NUMERO_ALIENS_LINHA-1){          //       DO ALIEN NA METADE DA CONTAGEM DA VELOCIDADE
            if((i % 2) != 0){
              this.aliensV(i)(j).moveDireita()
            }
            else
              this.aliensV(i)(j).moveEsquerda()
          }
        }
      }
      else if (this.velocidade == velocidadeDefinida / 2){
        for(i <- 0 to Constantes.NUMERO_ALIENS_COLUNA-1){
          for(j <- 0 to Constantes.NUMERO_ALIENS_LINHA-1){
            if((i % 2) != 0){
              this.aliensV(i)(j).moveEsquerda()
            }
            else
              this.aliensV(i)(j).moveDireita()
          }
        }
      }
      if (this.velocidade < 0)
        this.velocidade = velocidadeDefinida + 1
      this.velocidade = this.velocidade - 1
    }catch{
      case e:Exception => e.printStackTrace();
    }
  }
//****************************************************************************************
// VERIFICA SE O DISPARO DA NAVE ACERTOU ALGUM ALIEN DA MATRIZ OU PASSOU DO LIMITE SUPERIOR DA TELA
  def disparoNav(): Unit = {
    if(this.disparoNave.getAtivo){
      this.disparoNave.moveFrente()
    }
    if(this.disparoNave.getY < 0)
      this.disparoNave.desativa()

      for(i <- 0 to Constantes.NUMERO_ALIENS_COLUNA-1){
        for(j <- 0 to Constantes.NUMERO_ALIENS_LINHA-1){
          if(((this.disparoNave.getX > aliensV(i)(j).getX - 10) && (this.disparoNave.getX < aliensV(i)(j).getX + 10)) && (this.disparoNave.getY == aliensV(i)(j).getY) && (aliensV(i)(j).getAtivo))
                 {  this.disparoNave.desativa()
                   this.aliensV(i)(j).desativa()
                   aliensMortos +=1
                   pontuacao += 10
                 }
        }
      }

}
//*****************************************************************************************8
  def getAliens(i : Int,j : Int): Alien = {
    return aliensV(i)(j)
  }
//***************************************************************************************
// CONTROLA  A MOVIMENTAÇÃO DOS DISPAROS DE TODOS OS ALIENS, CRIA DISPAROS DE ALIENS RANDOMICAMENTE
  def disparoAliens(): Unit = {
      val i = iRandomico.nextInt(200) % Constantes.NUMERO_ALIENS_COLUNA
      val j = jRandomico.nextInt(200) % Constantes.NUMERO_ALIENS_LINHA

      if((this.velocidade == velocidadeDefinida / 2 ) || (this.velocidade == velocidadeDefinida / 4) || (this.velocidade == velocidadeDefinida))
        aliensV(i)(j).dispara()

        for(i <- 0 to Constantes.NUMERO_ALIENS_COLUNA-1){
          for(j <- 0 to Constantes.NUMERO_ALIENS_LINHA-1){
            if(aliensV(i)(j).getAtivo && aliensV(i)(j).disparo.getAtivo )
              aliensV(i)(j).disparo.moveTras()
              if((aliensV(i)(j).disparo.getX > nave.getX - 10) && (aliensV(i)(j).disparo.getX < nave.getX + 10) && (aliensV(i)(j).disparo.getY == nave.getY))
                vida -= 1
            }

          }
      if(aliensV(i)(j).disparo.getY > 500){
        aliensV(i)(j).disparo.desativa()
        aliensV(i)(j).disparo.set(aliensV(i)(j).getX,aliensV(i)(j).getY, false)
      }
  }
  def ganhou(): Boolean = {
    if(aliensMortos == Constantes.NUMERO_ALIENS_LINHA * Constantes.NUMERO_ALIENS_COLUNA)
      return true
    else
      return false
  }
}
