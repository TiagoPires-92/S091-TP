package Aula06_APS;

import java.util.List;

//DICA: aqui estamos fazendo muita coisa
public interface PessoaService {

	BancoDados validaMetodo(String metodo);

	List<PessoaFisica> getPessoaFisicaList(String metodo);

	public void salvaPessoaJuridica(PessoaJuridica pessoaJuridica, String metodo) throws Exception;

	public void salvaPessoaFísica(PessoaFisica pessoaFisica, String método) throws Exception;

	public void remover(Integer idPessoa, String metodo) throws Exception;

	public Pessoa busca(Integer idPessoa, String metodo);

	// salario somente de pessoa fisica
	public String calculaSalario(String metodo);

}
