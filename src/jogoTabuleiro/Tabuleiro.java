package jogoTabuleiro;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas; //matriz que conterá as peças no tabuleiro

	public Tabuleiro(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}
	
	//Método retorna uma peça, dada uma linha e uma coluna
	public Peca peca(int linha, int coluna) {
		return pecas[linha][coluna];
	}
	
	//Método retorna uma peça, dada sua posicao
	public Peca peca(Posicao posicao) {
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	//Método atribui uma peça a uma dada posição na matriz de peças instanciada no construtor
	public void lugarPeca(Peca peca, Posicao posicao) {
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao; //atualiza a posicao da peca, na classe peca
	}
	
	
}
