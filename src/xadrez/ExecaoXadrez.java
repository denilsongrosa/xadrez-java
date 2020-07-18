package xadrez;

import jogoTabuleiro.ExecaoTabuleiro;

//A Exeção fois tranformada de RuntimeExeption para ExecaoTabuleiro, pois 
//uma execção do xadrez também é uma exeção de tabuleiro, dessa forma ao hamar uma 
//exeção de xadrez, também pode ser tratado uma exeção do tabulero

public class ExecaoXadrez extends ExecaoTabuleiro{

	private static final long serialVersionUID = 1L;

	public ExecaoXadrez(String mensagem){
		super(mensagem);
	}
	
	
}
