package aplicacao;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		while (true) {
			UI.imprimirTabuleiro(partidaXadrez.getPecas()); //imprime o tabuleiro na tela
			System.out.println();
			System.out.print("Origem: ");
			PosicaoXadrez origem = UI.leituraPosicaoXadrez(sc);
			
			System.out.println();
			System.out.print("Destino: ");
			PosicaoXadrez destino = UI.leituraPosicaoXadrez(sc);
			
			PecaXadrez pecaCapturada = partidaXadrez.moverPeca(origem, destino);
		}
		
	}

}
