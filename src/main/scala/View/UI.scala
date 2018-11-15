package View

import javax.swing.{JFrame,WindowConstants, JLabel, JPanel, ImageIcon}
import java.awt.event._
import java.awt.Color
import java.awt.Dimension
import Controller._
import java.time._

class UI() extends JFrame with KeyListener {
  private val titulo: String = "Space Invaders"
  private var tecla: Int = 0
  private var controle: Controller = new Controller()
  private var labelNave: JLabel = new JLabel(controle.getNave.getImgNave)
  private var labelDisparo: JLabel = new JLabel()
  private var labelAlien: JLabel = new JLabel(controle.getAlien.getImgAlien)
  private var tela: JFrame = new JFrame()
  private var panel: JPanel = new JPanel();

  def iniciar(): Unit ={
    this.tela.setTitle(titulo);
    this.tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.tela.setSize(600, 600);
    this.tela.setLocationRelativeTo(null);
    this.tela.addKeyListener(this)
    this.tela.setResizable(false);
    this.panel.setBackground(Color.black)
    this.panel.add(this.labelNave)
    this.panel.add(this.labelAlien)
    this.panel.setBounds(0,0,600,600)
    this.panel.setLayout(null)
    this.tela.add(this.panel)
    this.tela.setVisible(true)
  }

  def keyPressed(k:KeyEvent): Unit = {
      this.tecla = k.getKeyCode()
      controle.setTecla(this.tecla)
      controle.Nave()
  }
  def keyReleased(k:KeyEvent): Unit = {
  }

  def keyTyped(k:KeyEvent): Unit = {
  }

  def printNave(): Unit = {
    this.labelNave.setBounds(controle.getNave.getX,controle.getNave.getY,100,100)
    this.labelAlien.setBounds(controle.getAlien.getX,controle.getAlien.getY,100,100)


  }
}
