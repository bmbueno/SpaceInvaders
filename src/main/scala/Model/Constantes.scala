package Model

import javax.swing.{ImageIcon}

object Constantes {
  val SEED_PARA_RAND = 2000

  val NUMERO_ALIENS_LINHA = 11
  val NUMERO_ALIENS_COLUNA = 3

  val INVALID_COORDINATES = -1

  val TAM_DISPARO_ALIEN_X = 5
  val TAM_DISPARO_ALIEN_Y = 12
  val VELOCIDADE_DISPARO_ALIEN = 5
  val INICIO_X_INIMIGOS = 40
  val INICIO_Y_INIMIGOS = 40

  val TAM_DISPARO_NAVE_X = 5
  val TAM_DISPARO_NAVE_Y = 10
  val VELOCIDADE_DISPARO_NAVE = 10

  val VELOCIDADE_ALIEN_X = 30
  val LARGURA_ALIEN = 40
  val COMPRIMENTO_ALIEN = 30
  val VELOCIDADE_ALIEN_FACIL = 4*VELOCIDADE_ALIEN_X
  val VELOCIDADE_ALIEN_MEDIO = 2*VELOCIDADE_ALIEN_X
  val VELOCIDADE_ALIEN_DIFICIL = VELOCIDADE_ALIEN_X

  val VELOCIDADE_NAVE = 3
  val LARGURA_NAVE = 50
  val COMPRIMENTO_NAVE = 25
  val POSX_NAVE = 300
  val POSY_NAVE = 500

  val WIDTH = 600
  val HEIGHT = 600

  val CHAO = 600

  val GAP_PARA_ALIENS = 30
  val ALIEN_JUMP = 20

  val IMG_ALIEN1: ImageIcon = new ImageIcon(System.getProperty("user.dir") + "/src/main/scala/View/alien.gif")
  IMG_ALIEN1.setImage(IMG_ALIEN1.getImage().getScaledInstance(50,50,10))

  val IMG_ALIEN2: ImageIcon = new ImageIcon(System.getProperty("user.dir") + "/src/main/scala/View/alien.gif")
  IMG_ALIEN2.setImage(IMG_ALIEN2.getImage().getScaledInstance(50,50,10))

  val IMG_ALIEN3: ImageIcon = new ImageIcon(System.getProperty("user.dir") + "/src/main/scala/View/alien.gif")
  IMG_ALIEN3.setImage(IMG_ALIEN3.getImage().getScaledInstance(50,50,10))

  val IMG_NAVE: ImageIcon = new ImageIcon(System.getProperty("user.dir") + "/src/main/scala/View/nave.jpeg")
  IMG_NAVE.setImage(IMG_NAVE.getImage().getScaledInstance(30,30,10))

  val IMG_DISPARO: ImageIcon = new ImageIcon(System.getProperty("user.dir") + "/src/main/scala/View/disparo.jpeg")
  IMG_DISPARO.setImage(IMG_DISPARO.getImage().getScaledInstance(10,20,10))
}
