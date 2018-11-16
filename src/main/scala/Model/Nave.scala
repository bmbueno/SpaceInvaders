package Model

import javax.swing.{ImageIcon}

class Nave(coordX: Int, coordY: Int) extends Alien(coordX,coordY){

  private val imgNave: ImageIcon = new ImageIcon(System.getProperty("user.dir") + "/src/main/scala/View/nave.jpeg")
  imgNave.setImage(imgNave.getImage().getScaledInstance(30,30,10))

  def getImgNave = imgNave
  def moveTras(): Unit = {
    this.y = this.y - 10
  }


}
