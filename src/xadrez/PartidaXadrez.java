package xadrez;

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
	
	//m�todo respons�vel por iniciar a partida de xadrez colocando as pe�as no tabuleiro
	private void setupInicial() {
		//Colocando a pe�a Torre da cor branca na posi��o 2,1
		tabuleiro.lugarPeca(new Torre(tabuleiro, Cor.WHITE), new Posicao(2, 1));
		tabuleiro.lugarPeca(  new Rei(tabuleiro, Cor.BLACK), new Posicao(0, 4));
		tabuleiro.lugarPeca(  new Rei(tabuleiro, Cor.WHITE), new Posicao(7, 4));
		
	}
	
}
