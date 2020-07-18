package xadrez;

import jogoTabuleiro.Posicao;

public class PosicaoXadrez {

	private char coluna;
	private int linha;
	
	public PosicaoXadrez(char coluna, int linha) {
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new ExecaoXadrez("Erro instanciando posi��o do xadrez, valores v�lidos de a1 a h8");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}

	/*
	A l�gica abaixo diz que, a posi��o de matriz do tabuleiro repsentado abaixo, pode ser acessada da seguinte forma:
	Linha -> cada linha pode ser obtida subtraindo a maior posi��o da posi��o alvo
	Coluna -> cada coluna pode ser obtida sutraindo o c�digo unicode da coluna a do c�digo unicode da coluna alvo.    
	8 - - - - - - - - 
	7 - - - - - - - - 
	6 - - - - - - - - 
	5 - - - - - - - - 
	4 - - - - - - - - 
	3 - - - - - - - - 
	2 - - - - - - - - 
	1 - - - - - - - - 
	  a b c d e f g h
	*/
	//Assim para o m�todo abaixo, dada uma posi��o do xadrez, ele retorna uma posi��o da matriz
	//Classe origem: toPosition
	protected Posicao paraPosicaoMtz() {
		return new Posicao(8 - this.linha, this.coluna - 'a');		
	}
	
	
	//O m�todo abaixo faz o inverso do m�todo anterior, dada uma posi��o de matriz, ele retorna uma posi��o do xadrez
	//Classe origem: fromPosition 
	protected static PosicaoXadrez  daPosicaoXadrez(Posicao posicao) {
		//No xadrez primeiro se fala a coluna depois se fala a linha
		return new PosicaoXadrez((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());
	}
	
	@Override
	public String toString() {
		//a String vazia no in�cio, � pra for�ar o compilador a entender que o resultado � uma concatena��ode Strings
		return "" + this.coluna + this.linha; 
		
	}
}
