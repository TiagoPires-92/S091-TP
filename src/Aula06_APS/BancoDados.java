package Aula06_APS;


import java.util.List;

public interface BancoDados {

	public void salvar(Pessoa pessoa);

	public void remover(Integer idPessoa);

	public Pessoa buscarListaPessoa(Pessoa pessoa);

	public List<Pessoa> buscarListaPessoa();

}