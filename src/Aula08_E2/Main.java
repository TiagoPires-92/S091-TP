package Aula08_E2;

/* Digamos que temos um sistema que ao comprar um produto, 
ele deve salvar o produto no banco de dados e enviar um email para o cliente.
Pensando nesse cen�rio, implemente o padr�o de projeto Facade que ao salvar esse produto,
tenha uma facade, que execute todas as opera��es em um �nico ponto.*/

public class Main {

	public static void main(String[] args) {
		Produto produto = new Produto();
		produto.id = 123;
		produto.nomeProduto = "C�psula de caf�";
		produto.precoProduto = 27;
		produto.nomeComprador = "Fulano de Tal";
		produto.emailComprador = "fulano.tal@estudante.senai.edu.br";
		
		ProdutoFacade produtoFacade = new ProdutoFacade();
		produtoFacade.comprarProduto(produto);
		

	}

}
