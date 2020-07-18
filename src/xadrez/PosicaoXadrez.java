package xadrez;

import jogoTabuleiro.Posicao;

public class PosicaoXadrez {

	private char coluna;
	private int linha;
	
	public PosicaoXadrez(char coluna, int linha) {
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new ExecaoXadrez("Erro instanciando posição do xadrez, valores válidos de a1 a h8");
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
	A lógica abaixo diz que, a posição de matriz do tabuleiro repsentado abaixo, pode ser acessada da seguinte forma:
	Linha -> cada linha pode ser obtida subtraindo a maior posição da posição alvo
	Coluna -> cada coluna pode ser obtida sutraindo o código unicode da coluna a do código unicode da coluna alvo.    
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
	//Assim para o método abaixo, dada uma posição do xadrez, ele retorna uma posição da matriz
	//Classe origem: toPosition
	protected Posicao paraPosicaoMtz() {
		return new Posicao(8 - this.linha, this.coluna - 'a');		
	}
	
	
	//O método abaixo faz o inverso do método anterior, dada uma posição de matriz, ele retorna uma posição do xadrez
	//Classe origem: fromPosition 
	protected static PosicaoXadrez  daPosicaoXadrez(Posicao posicao) {
		//No xadrez primeiro se fala a coluna depois se fala a linha
		return new PosicaoXadrez((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());
	}
	
	@Override
	public String toString() {
		//a String vazia no início, é pra forçar o compilador a entender que o resultado é uma concatenaçãode Strings
		return "" + this.coluna + this.linha; 
		
	}
}
