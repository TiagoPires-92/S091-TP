package Aula03_E1;


public class Main {

	public static void main(String[] args) {
		Cadastrar cadastro = new Cadastrar();
		Televisao tv1 = new Televisao("Samsung",42);	
		cadastro.adicionar(tv1);
		System.out.println(cadastro.buscarTelevisao("CCE"));


	}

}

