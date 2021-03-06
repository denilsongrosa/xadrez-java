package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.ExecaoXadrez;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		while (true) {
			try {
				UI.limpaTela();
				UI.imprimirTabuleiro(partidaXadrez.getPecas()); //imprime o tabuleiro na tela
				System.out.println();
				System.out.print("Origem: ");
				PosicaoXadrez origem = UI.leituraPosicaoXadrez(sc);
				
				System.out.println();
				System.out.print("Destino: ");
				PosicaoXadrez destino = UI.leituraPosicaoXadrez(sc);
				
				PecaXadrez pecaCapturada = partidaXadrez.moverPeca(origem, destino);
			}
			catch (ExecaoXadrez e) {
				System.out.println(e.getMessage());
				sc.nextLine(); //essa instru��o faz o programa aguardar um enter pra continuar
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine(); //essa instru��o faz o programa aguardar um enter pra continuar
			}

		}
		
	}

}
