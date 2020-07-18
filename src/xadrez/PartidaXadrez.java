package xadrez;

import jogoTabuleiro.Peca;
import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro; //vari�vel repesente o tabuleiro na partida
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro (8, 8); //cria um tabuleiro nas medidas especificadas
		setupInicial();
	}
	
	
	//M�todo retorna uma matriz de pe�as de xadrez, correspodente a uma partida
	public PecaXadrez[][] getPecas(){
		//Instancia de uma matriz de pe�a, que cont�m a quantidade de linhas e colunas do tabuleiro 
		PecaXadrez[][] mtz = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		//for percorre a matriz de pe�a do tabuleiro acima
		for (int i=0; i< tabuleiro.getLinhas(); i++) {
			for (int j=0; j < tabuleiro.getColunas(); j++) {
				//Para cada posi��o da matriz de pe�as do tabuleiro � atribuida uma pe�a
				//� utilizada um DownCast para transforma a pe�a comum em uma pe�a de xadrez
				mtz[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return mtz; //retorna a matriz de pe�as da partida de xadrez
	}
	
	//Classe origem: performChessMove
	public PecaXadrez moverPeca(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem  = posicaoOrigem.paraPosicaoMtz();
		Posicao destino = posicaoDestino.paraPosicaoMtz();
		validarPosicaoOrigem(origem);
		Peca pecaCapturada = executarMovimento(origem, destino);
		return (PecaXadrez)pecaCapturada; //� realizado o do dowcasting pois a pe�a capturada � do tipo Peca
	}
	
	//Classe origem: makeMove
	private Peca executarMovimento(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removePeca(origem); //retira a pe�a da posicao de origem
		Peca pecaCapturada = tabuleiro.removePeca(destino); //remove uma pe�a na posicao destino caso tenha, e a pactura
		tabuleiro.lugarPeca(p, destino); //coloca a pe�a que estava na posi��o de origem na posi��o de destino]
		return pecaCapturada; //retorna  pe�a capturada
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.existePeca(posicao)) {
			throw new ExecaoXadrez("N�o existe pe�a na posi��o de origem");
		}
	}
	
	//M�todo abaixo coloca uma pe�a na posi��o da matriz, recebendo a pe�a na posi��o do xadrez
	private void lugarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		this.tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicaoMtz());
	}
	
	//m�todo respons�vel por iniciar a partida de xadrez colocando as pe�as no tabuleiro
	private void setupInicial() {
		//Colocando a pe�a Torre da cor branca na posi��o 2,1
		lugarNovaPeca('c', 1, new Torre(tabuleiro, Cor.WHITE));
		lugarNovaPeca('c', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarNovaPeca('d', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarNovaPeca('e', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarNovaPeca('e', 1, new Torre(tabuleiro, Cor.WHITE));
		lugarNovaPeca('d', 1, new Rei(tabuleiro, Cor.WHITE));

		lugarNovaPeca('c', 7, new Torre(tabuleiro, Cor.BLACK));
		lugarNovaPeca('c', 8, new Torre(tabuleiro, Cor.BLACK));
		lugarNovaPeca('d', 7, new Torre(tabuleiro, Cor.BLACK));
		lugarNovaPeca('e', 7, new Torre(tabuleiro, Cor.BLACK));
		lugarNovaPeca('e', 8, new Torre(tabuleiro, Cor.BLACK));
		lugarNovaPeca('d', 8, new Rei(tabuleiro, Cor.BLACK));
		
	}
	
}
