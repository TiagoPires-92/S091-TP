package Aula06_APS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BancoDadosLista implements BancoDados {

	private List<Pessoa> listaPessoa = new ArrayList<Pessoa>();

	@Override
	public void salvar(Pessoa pessoa) {
		listaPessoa.add(pessoa);
	}

	@Override
	public void remover(Integer idPessoa) {
		Iterator<Pessoa> it = listaPessoa.iterator();

		while(it.hasNext()) {
			Pessoa p = it.next();
			if(p.getId().equals(idPessoa)) {
				it.remove();
				break;
			}
		}
	}

	@Override
	public Pessoa buscarListaPessoa(Pessoa pessoa) {
		Iterator<Pessoa> it = listaPessoa.iterator();

		while(it.hasNext()) {
			Pessoa p = it.next();
			if(p.getId().equals(pessoa.getId())) {
				return p;
			}
		}
		return null;
	}

	@Override
	public List<Pessoa> buscarListaPessoa() {
		return listaPessoa;
	}
}
