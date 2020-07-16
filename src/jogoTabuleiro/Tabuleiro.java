package jogoTabuleiro;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas; //matriz que conter� as pe�as no tabuleiro

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
	
	//M�todo retorna uma pe�a, dada uma linha e uma coluna
	public Peca peca(int linha, int coluna) {
		return pecas[linha][coluna];
	}
	
	//M�todo retorna uma pe�a, dada sua posicao
	public Peca peca(Posicao posicao) {
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	//M�todo atribui uma pe�a a uma dada posi��o na matriz de pe�as instanciada no construtor
	public void lugarPeca(Peca peca, Posicao posicao) {
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao; //atualiza a posicao da peca, na classe peca
	}
	
	
}
