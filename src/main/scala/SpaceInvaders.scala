import Model.Nave
import View.{Interface}
import java.time._
import java.awt.event._

object SpaceInvaders {
  def main(args: Array[String]): Unit = {
    val interface: Interface = new Interface(600,600);
    val nave: Nave = new Nave("1", 300, 300);
    val nave2: Nave = new Nave("3", 301, 300);

    interface.iniciar()
    for (i <- 0 to 10)
    {
    nave.printPersonagem(interface)
    Thread.sleep(100)
    nave.moveParaFrente()
    nave.printPersonagem(interface);
}
if(KeyEvent.VK_ENTER != 3){
  println("foi")
}
}}
