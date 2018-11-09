package View

import javax.swing.{JFrame, WindowConstants}
import java.awt.event._

class Interface(width:Int, height:Int) extends JFrame with KeyListener{
  private val titulo:String = "SPACE INVADERS";
  private val largura:Int = width;
  private val altura:Int = height;
  var tecla:Int = 0


  def iniciar(): Unit ={
    this.setTitle(titulo);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setSize(largura, altura);
    this.setLocationRelativeTo(null);
    this.addKeyListener(this)
    this.setVisible(true);
    this.setResizable(false);

  }

  def getLargura(): Int = {
    return this.largura;
  }
  def getAltura(): Int = {
    return this.altura;
  }

  def keyPressed(k:KeyEvent): Unit = {
      this.tecla = k.getKeyCode()
  }
  def keyReleased(k:KeyEvent): Unit = {
  }

  def keyTyped(k:KeyEvent): Unit = {
  }
  
}
