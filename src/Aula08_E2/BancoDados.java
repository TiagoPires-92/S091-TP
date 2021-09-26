package Aula08_E2;

public class BancoDados {
	
	public void salvarBancoDados(Produto produto) {
		System.out.println("ModuloBancoDados: salvando o produto com os dados:");
		System.out.println("\tId do produto: " + produto.id);
		System.out.println("\tNome do produto: " + produto.nomeProduto);
		System.out.println("\tValor de R$" + produto.precoProduto);
	}

}
