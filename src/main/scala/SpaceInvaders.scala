import Model._
import View.{Interface}
import java.time._
import java.awt.event._
import scala.collection.mutable.ListBuffer

object SpaceInvaders {
  def main(args: Array[String]): Unit = {
    val interface: Interface = new Interface(600,600);
    val nave: Nave = new Nave("1", 300, 500);
    val nave2: Nave = new Nave("3", 301, 300);
    val inimigo: Inimigo = new Inimigo("U",100,100)
    var numInimigos: Int = 5
    var vetorInimigos: ListBuffer[Inimigo] = new ListBuffer[Inimigo]

    interface.iniciar()

    while(true){
      nave.printPersonagem(interface)
      Thread.sleep(100)
      nave.printPersonagem(interface)
      nave.moveuNave(interface.tecla,600,600)
      interface.tecla = 0
      if(numInimigos > 0){
        vetorInimigos = inimigo.ondaInimigos(interface,10)
        numInimigos = 0

      for(inimigo <- vetorInimigos)
        inimigo.printPersonagem(interface)
        Thread.sleep(100)


        inimigo.printPersonagem(interface)
}
inimigo.moveParaDireita()
    }

  }
}
