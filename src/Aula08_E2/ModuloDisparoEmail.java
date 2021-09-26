package Aula08_E2;

public class ModuloDisparoEmail {
	
	public void dispararEmail(Produto produto) {
		System.out.println("ModuloDisparoEmail: Disparando email para o endereço: " 
				+ produto.emailComprador + ", aos cuidados de: " + produto.nomeComprador);
	}

}
