package Aula06_APS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoDadosMapa implements BancoDados {

	private Map<Integer,Pessoa> PessoaMap = new HashMap<Integer,Pessoa>();

	@Override
	public void salvar(Pessoa pessoa) {
		PessoaMap.put(pessoa.getId(), pessoa);
	}

	@Override
	public void remover(Integer idPessoa) {
		PessoaMap.remove(idPessoa);
	}

	@Override
	public Pessoa buscarListaPessoa(Pessoa pessoa) {
		return PessoaMap.get(pessoa.getId());
	}

	@Override
	public List<Pessoa> buscarListaPessoa() {
		return new ArrayList<>(PessoaMap.values());
	}
}

