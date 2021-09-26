package Aula08_E2;

public class ProdutoFacade {
	
	private BancoDados moduloBancoDados = new BancoDados();
	private ModuloDisparoEmail moduloDisparoEmail = new ModuloDisparoEmail();
	
	public void comprarProduto(Produto produto) {
		System.out.println("Realizando um compra");
		moduloDisparoEmail.dispararEmail(produto);
		moduloBancoDados.salvarBancoDados(produto);
	}

}
