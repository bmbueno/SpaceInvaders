package View

import javax.swing.{JFrame,WindowConstants, JLabel, JPanel, ImageIcon}
import java.awt.event._
import java.awt.Color
import java.awt.Dimension
import Controller._
import java.time._
import Array.ofDim

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
  private var labelsAliensV = ofDim[JLabel](controle.getNumAliensColuna,controle.getNumAliens)
  private var labelsDisparoAliens = ofDim[JLabel](controle.getNumAliensColuna,controle.getNumAliens)
  private var labelVida: JLabel = new JLabel()
  private var labelPontuacao: JLabel = new JLabel()

  def iniciar(): Unit ={
    this.controle.setDificuldade("Dificil")
    this.tela.setTitle(titulo);
    this.tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.tela.setSize(600, 600);
    this.tela.setLocationRelativeTo(null);
    this.tela.addKeyListener(this)
    this.tela.setResizable(false);
    this.panel.setBackground(Color.black)

    for(i <- 0 to controle.getNumAliensColuna-1){
      for(j <- 0 to controle.getNumAliens-1){
        labelsAliensV(i)(j) = new JLabel(controle.getImagemAlien1)
        this.panel.add(this.labelsAliensV(i)(j))
      }
    }
    for(i <- 0 to controle.getNumAliensColuna-1){
      for(j <- 0 to controle.getNumAliens-1){
        labelsDisparoAliens(i)(j) = new JLabel(controle.getImagemDisparo)
        this.panel.add(this.labelsDisparoAliens(i)(j))
      }
    }


    this.panel.add(this.labelNave)
    this.panel.add(this.labelVida)
    this.panel.add(this.labelPontuacao)
    this.panel.add(this.labelDisparo)
    this.panel.setBounds(0,0,600,600)
    this.panel.setLayout(null)
    this.tela.add(this.panel)
    this.tela.setVisible(true)

    controle.inicializa()
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
  }
  def printAliens(): Unit = {
    for(i <- 0 to controle.getNumAliensColuna-1){
      for(j <- 0 to controle.getNumAliens-1){
        if(controle.getAliens(i,j).getAtivo)
             this.labelsAliensV(i)(j).setBounds(controle.getAliens(i,j).getX,controle.getAliens(i,j).getY,100,100)
           else
             this.labelsAliensV(i)(j).setBounds(controle.getAliens(i,j).getX,controle.getAliens(i,j).getY,0,0)
      }
    }
    controle.Alien()
}
    def printDisparo(): Unit = {
      if(controle.getDisparo.getAtivo){
        this.labelDisparo.setBounds(controle.getDisparo.getX,controle.getDisparo.getY,100,100)
        controle.disparoNav()
    } else
        this.labelDisparo.setBounds(controle.getDisparo.getX,controle.getDisparo.getY,0,0)
  }
    def printDisparoAliens(): Unit = {
      for(i <- 0 to controle.getNumAliensColuna-1){
        for(j <- 0 to controle.getNumAliens-1){
          if(controle.getAliens(i,j).disparo.getAtivo && controle.getAliens(i,j).getAtivo)
               this.labelsDisparoAliens(i)(j).setBounds(controle.getAliens(i,j).disparo.getX,controle.getAliens(i,j).disparo.getY,100,100)
             else
               this.labelsDisparoAliens(i)(j).setBounds(controle.getAliens(i,j).disparo.getX,controle.getAliens(i,j).disparo.getY,0,0)
        }
      }
      controle.disparoAliens()
    }
    def printInfo(): Unit = {
      this.labelVida.setBounds(100,0,100,50)
      this.labelVida.setText("Vidas:  " + controle.getVida.toString)
      this.labelVida.setForeground(Color.yellow)

      this.labelPontuacao.setBounds(200,0,100,50)
      this.labelPontuacao.setText("Score:  " + controle.getPontuação.toString)
      this.labelPontuacao.setForeground(Color.yellow)
    }


}
