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
	
	//método responsável por iniciar a partida de xadrez colocando as peças no tabuleiro
	private void setupInicial() {
		//Colocando a peça Torre da cor branca na posição 2,1
		tabuleiro.lugarPeca(new Torre(tabuleiro, Cor.WHITE), new Posicao(2, 1));
		tabuleiro.lugarPeca(  new Rei(tabuleiro, Cor.BLACK), new Posicao(0, 4));
		tabuleiro.lugarPeca(  new Rei(tabuleiro, Cor.WHITE), new Posicao(7, 4));
		
	}
	
}
