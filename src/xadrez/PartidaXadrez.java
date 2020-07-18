package xadrez;

import jogoTabuleiro.Peca;
import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro; //variável repesente o tabuleiro na partida
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro (8, 8); //cria um tabuleiro nas medidas especificadas
		setupInicial();
	}
	
	
	//Método retorna uma matriz de peças de xadrez, correspodente a uma partida
	public PecaXadrez[][] getPecas(){
		//Instancia de uma matriz de peça, que contém a quantidade de linhas e colunas do tabuleiro 
		PecaXadrez[][] mtz = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		//for percorre a matriz de peça do tabuleiro acima
		for (int i=0; i< tabuleiro.getLinhas(); i++) {
			for (int j=0; j < tabuleiro.getColunas(); j++) {
				//Para cada posição da matriz de peças do tabuleiro é atribuida uma peça
				//é utilizada um DownCast para transforma a peça comum em uma peça de xadrez
				mtz[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return mtz; //retorna a matriz de peças da partida de xadrez
	}
	
	//Classe origem: performChessMove
	public PecaXadrez moverPeca(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem  = posicaoOrigem.paraPosicaoMtz();
		Posicao destino = posicaoDestino.paraPosicaoMtz();
		validarPosicaoOrigem(origem);
		Peca pecaCapturada = executarMovimento(origem, destino);
		return (PecaXadrez)pecaCapturada; //é realizado o do dowcasting pois a peça capturada é do tipo Peca
	}
	
	//Classe origem: makeMove
	private Peca executarMovimento(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removePeca(origem); //retira a peça da posicao de origem
		Peca pecaCapturada = tabuleiro.removePeca(destino); //remove uma peça na posicao destino caso tenha, e a pactura
		tabuleiro.lugarPeca(p, destino); //coloca a peça que estava na posição de origem na posição de destino]
		return pecaCapturada; //retorna  peça capturada
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.existePeca(posicao)) {
			throw new ExecaoXadrez("Não existe peça na posição de origem");
		}
	}
	
	//Método abaixo coloca uma peça na posição da matriz, recebendo a peça na posição do xadrez
	private void lugarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		this.tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicaoMtz());
	}
	
	//método responsável por iniciar a partida de xadrez colocando as peças no tabuleiro
	private void setupInicial() {
		//Colocando a peça Torre da cor branca na posição 2,1
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
