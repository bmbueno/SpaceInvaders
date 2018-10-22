package Control

import Model.{DisparoNave, Inimigo, Nave}
import View.Interface

class ControleColisoes {

  def testaColisao(nave:Nave, inimigo:Inimigo): Unit ={
    var colisao: Boolean = false;
    if(nave.getCoordenadaX() == inimigo.getCoordenadaX() && nave.getCoordenadaY() == nave.getCoordenadaY()){
      colisao = true;
      nave.finalize();
      inimigo.finalize();
    }
    return colisao;
  }

  def testaColisao(nave:Nave, interface: Interface): Boolean ={
    var colisao: Boolean = false;
    if(nave.getCoordenadaX() < 0 || nave.getCoordenadaX() > interface.getLargura()){
      colisao = true;
    }else if(nave.getCoordenadaY() < 0 || nave.getCoordenadaY() > interface.getAltura()){
      colisao = true;
    }

    return colisao;
  }

  def testaColisao(inimigo: Inimigo, disparoNave: DisparoNave): Boolean ={

    if(inimigo.getCoordenadaY() == disparoNave.getCoordenadaY() && inimigo.getCoordenadaX() == disparoNave.getCoordenadaX()){
      inimigo.finalize();
      disparoNave.finalize();
    }
    return false;
  }

}
