package Aula03_E1;


public class Televisao {
	String nome; 
	int tamanho; 

	public Televisao(String nome, int tamanho) {
		this.nome = nome;
		this.tamanho = tamanho;
		try{
			validarTelevisao(nome, tamanho);
		}catch(Exception e){
			System.out.println("Error");
		}   
	}



	private void validarTelevisao(String nome, int tamanho) throws Exception{		
		if(nome.equals("") || (tamanho < 0 || tamanho > 100)) {
			throw new Exception("error");
		}
		if(nome == null) {
			throw new Exception("Objecto Tv esta null");
		}

	}

	@Override
	public String toString() {
		return "Televisao: " + "Nome: " + nome + " "
				+ "Tamanho:" + tamanho;
	}

}
