package Aula01;

public class Principal {

	public static void main(String[] args) {
		
		// instanciacao da classe pessoa
		Pessoa maria = new Pessoa();
		maria.nome = "maria da silva";
		
		// instanciacao da classe endereco
		Endereco enderecoMaria = new Endereco();
		enderecoMaria.nomeRua = "assis brasil";
		
		// passando endereco para pessoa.
		maria.endereco = enderecoMaria;
		
		System.out.println("Pessoa: " + maria.nome);
		System.out.println("Pessoa Endereco: " + maria.endereco.nomeRua);
		
		
		// vamos fazer uso de herança agora.
		
		PessoaJuridica pj = new PessoaJuridica();
		pj.nome = "faculdade senai";
		pj.cnpj ="000185689955";
		Endereco enderecoPj = new Endereco();
		enderecoPj.nomeRua = "Av. Assis Brasil";
		pj.endereco = enderecoPj;
		
		PessoaFisica pf = new PessoaFisica();
		pf.nome = "pedro da silva";
		pf.cpf = "81426983568";
		Endereco enderecoPf = new Endereco();
		enderecoPf.nomeRua = "Carlos Gomes";
		pf.endereco = enderecoPf;
		
		System.out.println("PJ " + pj.nome );
		System.out.println("PJ ENDERECO " + pj.endereco.nomeRua );
		
		System.out.println("Pf " + pf.nome );
		System.out.println("Pf ENDERECO " + pf.endereco.nomeRua );
		
		System.out.println("EXEMPLO DE POLIMORFISMO");
		
		mostraNomePessoa(pj);
		mostraNomePessoa(pf);	
		
		
		// vamos fazer uso de interfaces (contratos) junto com polimorfimmo.
		ContaCorrente cc =  new ContaCorrente();
		ContaPoupanca cp= new ContaPoupanca();
		
		depositaSacaNaConta(cc);
		depositaSacaNaConta(cp);
	}
	
	public static void depositaSacaNaConta(Conta  conta) {
		conta.depositar(100f);
		conta.sacar(500f);
	}
	
	public static void mostraNomePessoa(Pessoa pessoa) {
		System.out.println("O nome da pessoa é: " + pessoa.nome);
	}

}
