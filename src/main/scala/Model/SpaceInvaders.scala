package Model

import View.UI

object SpaceInvaders {
  def main(args: Array[String]): Unit = {

    var interface: UI = new UI()

    interface.inicia()
    interface.iniciarJogo()

    while(true) {
    Thread.sleep(50)
     interface.printNave()
     interface.printDisparo()
     interface.printAliens()
     interface.printDisparoAliens()
     interface.printInfo()
     interface.verificaFimJogo()

}




}
}
