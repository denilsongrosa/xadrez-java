package xadrez;

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
	
	//Método abaixo coloca uma peça na posição da matriz, recebendo a peça na posição do xadrez
	private void lugarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		this.tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).getPosicaoMtz());
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
