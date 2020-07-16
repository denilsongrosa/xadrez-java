package jogoTabuleiro;

public class Peca {

	protected Posicao posicao; //Essa posição não será visível na camada xadrez, pois é a posição na matriz, não no tabuleiro
	private Tabuleiro tabuleiro; //A peça deve conhecer o tabuleiro onde esta
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null; //a posição inicial recebe null, pois uma peça recem criada, ainda não está no tabuleiro
	}

	//O método abaixo é protected para que somente as peças possam acessar os tabuleiros
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

}
