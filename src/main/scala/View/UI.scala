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
  private var labelDisparo: JLabel = new JLabel(controle.getDisparo.getImgDisparo)
  private var labelAlien: JLabel = new JLabel(controle.getAlien.getImgAlien)
  private var tela: JFrame = new JFrame()
  private var panel: JPanel = new JPanel();
  private var labelScore: JLabel = new JLabel()
  private var labelsAliens: Array[JLabel] = new Array[JLabel](controle.getNumAliens)
  private var labelsAliens1: Array[JLabel] = new Array[JLabel](controle.getNumAliens)
  private var labelsAliens2: Array[JLabel] = new Array[JLabel](controle.getNumAliens)

  def iniciar(): Unit ={
    this.controle.setDificuldade("Dificil")
    this.tela.setTitle(titulo);
    this.tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.tela.setSize(600, 600);
    this.tela.setLocationRelativeTo(null);
    this.tela.addKeyListener(this)
    this.tela.setResizable(false);
    this.panel.setBackground(Color.black)

    for(i <- 0 to controle.getNumAliens-1){
      labelsAliens(i) = new JLabel(controle.getAlien.getImgAlien)
      this.panel.add(this.labelsAliens(i))
    }
    for(i <- 0 to controle.getNumAliens-1){
      labelsAliens1(i) = new JLabel(controle.getAlien.getImgAlien1)
      this.panel.add(this.labelsAliens1(i))
    }
    for(i <- 0 to controle.getNumAliens-1){
      labelsAliens2(i) = new JLabel(controle.getAlien.getImgAlien2)
      this.panel.add(this.labelsAliens2(i))
    }
    this.panel.add(this.labelNave)
    //this.panel.add(this.labelAlien)
    this.panel.add(this.labelDisparo)
    this.panel.setBounds(0,0,600,600)
    this.panel.setLayout(null)
    this.tela.add(this.panel)
    this.tela.setVisible(true)

    controle.inicializaAliens()
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
    //this.labelAlien.setBounds(controle.getAlien.getX,controle.getAlien.getY,100,100)

    for(i <- 0 to controle.getNumAliens-1){
      if(controle.getAliens(i).getAtivo)
        this.labelsAliens(i).setBounds(controle.getAliens(i).getX,controle.getAliens(i).getY,100,100)
      else
        this.labelsAliens(i).setBounds(controle.getAliens(i).getX,controle.getAliens(i).getY,0,0)
    }
    for(i <- 0 to controle.getNumAliens-1){
      if(controle.getAliens1(i).getAtivo)
        this.labelsAliens1(i).setBounds(controle.getAliens1(i).getX,controle.getAliens1(i).getY,100,100)
      else
        this.labelsAliens1(i).setBounds(controle.getAliens1(i).getX,controle.getAliens1(i).getY,0,0)
    }
    for(i <- 0 to controle.getNumAliens-1){
      if(controle.getAliens2(i).getAtivo)
        this.labelsAliens2(i).setBounds(controle.getAliens2(i).getX,controle.getAliens2(i).getY,100,100)
      else
        this.labelsAliens2(i).setBounds(controle.getAliens2(i).getX,controle.getAliens2(i).getY,0,0)
    }
    controle.Alien()

    if(controle.getDisparo.getAtivo){
      this.labelDisparo.setBounds(controle.getDisparo.getX,controle.getDisparo.getY,100,100)
      controle.disparos()
  } else
      this.labelDisparo.setBounds(controle.getDisparo.getX,controle.getDisparo.getY,0,0)
}
}
