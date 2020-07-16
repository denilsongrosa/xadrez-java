package aplicacao;

import xadrez.PecaXadrez;

public class UI {
	
	//Classe utilizada para imprimir peças e tabuleiro
	
	
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
			System.out.print("-"); //impressão caso não tenha peça na posição atual
		}else {
			System.out.print(peca); //imprimi a peça caso tenha alguma na posição
		}
		System.out.print(" ");
	}
}
