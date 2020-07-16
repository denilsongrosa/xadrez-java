package xadrez;

import jogoTabuleiro.Peca;
import jogoTabuleiro.Tabuleiro;

public class PecaXadrez extends Peca{

	private Cor cor; //a cor de uma pe�a n�o deve ser alterada ap�s a cria��o, apenas acessada

	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}

}
