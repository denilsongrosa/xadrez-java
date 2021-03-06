package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.Cor;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class UI {
	
	//Classe utilizada para imprimir pe�as e tabuleiro
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	
	//Cores do texto
	public  static  final  String  ANSI_RESET  =  "\u001B[0m" ;
	public  static  final  String  ANSI_BLACK  =  "\u001B[30m" ;
	public  static  final  String  ANSI_RED  =  "\u001B[31m" ;
	public  static  final  String  ANSI_GREEN  =  "\u001B[32m" ;
	public  static  final  String  ANSI_YELLOW  =  "\u001B[33m" ;
	public  static  final  String  ANSI_BLUE  =  "\u001B[34m" ;
	public  static  final  String  ANSI_PURPLE  =  "\u001B[35m" ;
	public  static  final  String  ANSI_CYAN  =  "\u001B[36m" ;
	public  static  final  String  ANSI_WHITE  =  "\u001B[37m" ;

	//Cores do fundo
	public  static  final  String  ANSI_BLACK_BACKGROUND  =  "\u001B[40m" ;
	public  static  final  String  ANSI_RED_BACKGROUND  =  "\u001B[41m" ;
	public  static  final  String  ANSI_GREEN_BACKGROUND  =  "\u001B[42m" ;
	public  static  final  String  ANSI_YELLOW_BACKGROUND  =  "\u001B[43m " ;
	public  static  final  String  ANSI_BLUE_BACKGROUND  =  "\u001B[44m" ;
	public  static  final  String  ANSI_PURPLE_BACKGROUND  =  "\u001B[45m" ;
	public  static  final  String  ANSI_CYAN_BACKGROUND  =  "\u001B[46m" ;
	public  static  final  String  ANSI_WHITE_BACKGROUND  =  "\u001B[47m" ;
	
	//M�todo para limpar a tela.
	public static void limpaTela() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public static PosicaoXadrez leituraPosicaoXadrez(Scanner sc) {
		try {
			String s = sc.nextLine();
			char coluna = s.charAt(0); //a coluna est� na primeira posi��o da strng de posi��o a1
			int linha = Integer.parseInt(s.substring(1)); //pega a string a1 poe exemplo, e a recorta a partir da posi��o 1  converte para inteiro
			return new PosicaoXadrez(coluna, linha);
		}
		catch (RuntimeException e) {
			throw new InputMismatchException("Erro ao ler a posi��o. Valores v�lidos s�o de a1 at� h8");
		}
	}
	
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
        }
        else {
        	//o if abaixo verifica a cor de impress�o da pe�a, se a pe�a tem a cor branca, imprime no branco 
        	//se tem a cor preta imprimi no amarelo por causa do fundo do terminal
            if (peca.getCor() == Cor.WHITE) {
                System.out.print(ANSI_WHITE + peca + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
            }
        }
        System.out.print(" ");
	}
}
