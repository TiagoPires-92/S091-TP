package Aula03_E1;

import java.util.ArrayList;
import java.util.List;

public class Cadastrar{

	List<Televisao> lista = new ArrayList<>();
	public void adicionar(Televisao televisao) {

		try {
			ExcutarAdicionarTelevisao(televisao);
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}
	private void ExcutarAdicionarTelevisao(Televisao televisao){
		lista.add(televisao);
	}

	public Televisao buscarTelevisao(String nome) {
		Televisao resultado = null;
		for(Televisao televisao : lista) {

			if(televisao.nome.equals(nome)) {
				resultado = televisao;

			}
			if(resultado == null){
				System.out.println("Tv não existe");
				televisao.nome = "Tv não encontrada";
				televisao.tamanho = 0;

				resultado = televisao;
			}

		}
		return resultado;	
	}


}
