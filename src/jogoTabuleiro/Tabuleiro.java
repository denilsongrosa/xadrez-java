package jogoTabuleiro;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas; //matriz que conterá as peças no tabuleiro

	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new ExecaoTabuleiro("Erro criando Tabuleiro, é necessário que haja ao menos 1 linha e 1 coluna");
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

	//Método retorna uma peça, dada uma posição (linha,coluna)
	public Peca peca(int linha, int coluna) {
		if (!posicaoExistente(linha, coluna)){ //if verifica se a posição não existe
			throw new ExecaoTabuleiro("Posição não existe no tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	//Método retorna uma peça, dada sua posicao
	public Peca peca(Posicao posicao) {
		if (!posicaoExistente(posicao)){ //if verifica se a posição não existe
			throw new ExecaoTabuleiro("Posição não existe no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	//Método coloca uma peça em uma dada posição na matriz de peças instanciada no construtor
	public void lugarPeca(Peca peca, Posicao posicao) {
		if (existePeca(posicao)) { //if verifica se a posição pretendida ja não está ocupada
			throw new ExecaoTabuleiro("Há uma peça nessa posição: (" + posicao + ")");
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao; //atualiza a posicao da peca, na classe peca
	}
	
	public Peca removePeca(Posicao posicao) {
		if(!posicaoExistente(posicao)) {
			throw new ExecaoTabuleiro("Posição não existe no tabuleiro");
		}
		if(peca(posicao) == null) {
			return null;
		}else {
			Peca aux = peca(posicao);
			aux.posicao = null; //quando uma peça é retirada é atribuido null a posição dela
			this.pecas[posicao.getLinha()][posicao.getColuna()] = null; //quando uma peça é removida, a sua posição na matriz também recebe null
			return aux; //retorna  peça que foi retirada
		}
	}
	
	
	//Método específica as condições necessários para se existe uma posição no tabuleiro
	private boolean posicaoExistente(int linha, int coluna) {
		return linha >= 0 && linha < this.linhas && coluna >= 0 && coluna < this.colunas;
	}
	
	
	//Método abaixo utiliza o de cima para verificar se a posição passada existe
	public boolean posicaoExistente(Posicao posicao) {
		return posicaoExistente(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean existePeca(Posicao posicao) {
		if (!posicaoExistente(posicao)){ //if verifica se a posição não existe
			throw new ExecaoTabuleiro("Posição não existe no tabuleiro");
		}
		//caso a peça nessa posicao for diferente de null, significa que existe uma peça nessa posição
		return this.peca(posicao) != null; 
	}
}
