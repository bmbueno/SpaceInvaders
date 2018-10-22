package Model

class Jogador(nome: String) {
  val nomeJogador: String = nome;
  var pontuacao: Int = 0;

  def getNome: String = {
    return this.nomeJogador;
  }

  def getPontuacao: Int = {
    return this.pontuacao;
  }
  def atualizaPontuacao: Unit ={
    this.pontuacao += 1;
  }
  //-------------------------------------------------- [PRINTS]

  def printInformacoesJogador: Unit ={
    println("----------------");
    println("INFORMACOES JOGADOR");
    println("----------------");
    println("Nome: " + this.getNome);
    println("Pontuacao: " + this.getPontuacao);
    println("----------------");

  }

}
