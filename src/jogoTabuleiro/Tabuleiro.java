package jogoTabuleiro;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas; //matriz que conter� as pe�as no tabuleiro

	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new ExecaoTabuleiro("Erro criando Tabuleiro, � necess�rio que haja ao menos 1 linha e 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	//M�todo retorna uma pe�a, dada uma posi��o (linha,coluna)
	public Peca peca(int linha, int coluna) {
		if (!posicaoExistente(linha, coluna)){ //if verifica se a posi��o n�o existe
			throw new ExecaoTabuleiro("Posi��o n�o existe no tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	//M�todo retorna uma pe�a, dada sua posicao
	public Peca peca(Posicao posicao) {
		if (!posicaoExistente(posicao)){ //if verifica se a posi��o n�o existe
			throw new ExecaoTabuleiro("Posi��o n�o existe no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	//M�todo coloca uma pe�a em uma dada posi��o na matriz de pe�as instanciada no construtor
	public void lugarPeca(Peca peca, Posicao posicao) {
		if (existePeca(posicao)) { //if verifica se a posi��o pretendida ja n�o est� ocupada
			throw new ExecaoTabuleiro("H� uma pe�a nessa posi��o: (" + posicao + ")");
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao; //atualiza a posicao da peca, na classe peca
	}
	
	public Peca removePeca(Posicao posicao) {
		if(!posicaoExistente(posicao)) {
			throw new ExecaoTabuleiro("Posi��o n�o existe no tabuleiro");
		}
		if(peca(posicao) == null) {
			return null;
		}else {
			Peca aux = peca(posicao);
			aux.posicao = null; //quando uma pe�a � retirada � atribuido null a posi��o dela
			this.pecas[posicao.getLinha()][posicao.getColuna()] = null; //quando uma pe�a � removida, a sua posi��o na matriz tamb�m recebe null
			return aux; //retorna  pe�a que foi retirada
		}
	}
	
	
	//M�todo espec�fica as condi��es necess�rios para se existe uma posi��o no tabuleiro
	private boolean posicaoExistente(int linha, int coluna) {
		return linha >= 0 && linha < this.linhas && coluna >= 0 && coluna < this.colunas;
	}
	
	
	//M�todo abaixo utiliza o de cima para verificar se a posi��o passada existe
	public boolean posicaoExistente(Posicao posicao) {
		return posicaoExistente(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean existePeca(Posicao posicao) {
		if (!posicaoExistente(posicao)){ //if verifica se a posi��o n�o existe
			throw new ExecaoTabuleiro("Posi��o n�o existe no tabuleiro");
		}
		//caso a pe�a nessa posicao for diferente de null, significa que existe uma pe�a nessa posi��o
		return this.peca(posicao) != null; 
	}
}
