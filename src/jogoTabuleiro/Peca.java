package jogoTabuleiro;

public class Peca {

	protected Posicao posicao; //Essa posi��o n�o ser� vis�vel na camada xadrez, pois � a posi��o na matriz, n�o no tabuleiro
	private Tabuleiro tabuleiro; //A pe�a deve conhecer o tabuleiro onde esta
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null; //a posi��o inicial recebe null, pois uma pe�a recem criada, ainda n�o est� no tabuleiro
	}

	//O m�todo abaixo � protected para que somente as pe�as possam acessar os tabuleiros
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

}
