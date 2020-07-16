package aplicacao;

import xadrez.PecaXadrez;

public class UI {
	
	//Classe utilizada para imprimir pe�as e tabuleiro
	
	
	public static void imprimirTabuleiro(PecaXadrez[][] pecas) {
		for(int i =0; i<pecas.length; i++) {
			System.out.print((8-i) + " ");
			for (int j=0; j<pecas.length; j++) {
				imprimirPeca(pecas[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	private static void imprimirPeca(PecaXadrez peca) {
		if (peca == null) {
			System.out.print("-"); //impress�o caso n�o tenha pe�a na posi��o atual
		}else {
			System.out.print(peca); //imprimi a pe�a caso tenha alguma na posi��o
		}
		System.out.print(" ");
	}
}
