package jogoTabuleiro;

public class ExecaoTabuleiro extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ExecaoTabuleiro(String mensagem) {
		super(mensagem);
	}
}
