package Model

import View.UI

object SpaceInvaders {
  def main(args: Array[String]): Unit = {

    var interface: UI = new UI()

    interface.iniciar()

    while(true) {
    Thread.sleep(100)
    interface.printNave()
    interface.printDisparo()
    interface.printAliens()
    interface.printDisparoAliens()
    interface.printInfo()

}




}
}
