import Model.Nave
import View.{Interface}

object SpaceInvaders {
  def main(args: Array[String]): Unit = {
    val interface: Interface = new Interface(500,500);
    val nave: Nave = new Nave("#", 250, 450);
    val nave2: Nave = new Nave("#", 250, 451);

    interface.iniciar();

    nave.printPersonagem(interface);
    nave.printPersonagem(interface);


  }
}
