package xadrez;

import jogoTabuleiro.ExecaoTabuleiro;

//A Exe��o fois tranformada de RuntimeExeption para ExecaoTabuleiro, pois 
//uma exec��o do xadrez tamb�m � uma exe��o de tabuleiro, dessa forma ao hamar uma 
//exe��o de xadrez, tamb�m pode ser tratado uma exe��o do tabulero

public class ExecaoXadrez extends ExecaoTabuleiro{

	private static final long serialVersionUID = 1L;

	public ExecaoXadrez(String mensagem){
		super(mensagem);
	}
	
	
}
