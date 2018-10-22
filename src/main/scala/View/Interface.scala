package View

import javax.swing.{JFrame, WindowConstants}

class Interface(width:Int, height:Int) extends JFrame{
  private val titulo:String = "SPACE INVADERS";
  private val largura:Int = width;
  private val altura:Int = height;


  def iniciar(): Unit ={
    this.setTitle(titulo);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setSize(largura, altura);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.setResizable(false);

  }

  def getLargura(): Int = {
    return this.largura;
  }
  def getAltura(): Int = {
    return this.altura;
  }
}
