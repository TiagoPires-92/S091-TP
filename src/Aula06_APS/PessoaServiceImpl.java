package Aula06_APS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Esta classe e responsavel pela camada de negocio.
 * Ela faz a ligacao com a camada de dados.
 *
 */

public class PessoaServiceImpl implements PessoaService {

	private BancoDadosLista bancoDadosLista = new BancoDadosLista();
	private BancoDadosMapa bancoDadosMapa = new BancoDadosMapa();
	private static int contadorIDPessoa =0;

	@Override
	public BancoDados validaMetodo(String metodo) {
		if (metodo.equals("lista"))
			return bancoDadosLista;
		else
			return bancoDadosMapa;
	}

	@Override
	public void salvaPessoaFísica(PessoaFisica pessoaFisica, String metodo) throws Exception {

		validaPessoa(pessoaFisica);

		if(pessoaFisica.getSalario() == null || pessoaFisica.getSalario() < 0) {
			throw new IllegalArgumentException("Salario da pessoa fisca esta invalida");
		}
		pessoaFisica.setId(contadorIDPessoa++);
		validaMetodo(metodo).salvar(pessoaFisica);
	}

	@Override
	public void salvaPessoaJuridica(PessoaJuridica pessoaJuridica, String metodo) throws Exception {

		validaPessoa(pessoaJuridica);

		if(pessoaJuridica.getCnpj() == null || pessoaJuridica.equals("")) {
			throw new IllegalArgumentException("CNPJ da pessoa jurídica esta invalido");
		}

		pessoaJuridica.setId(contadorIDPessoa++);
		validaMetodo(metodo).salvar(pessoaJuridica);
	}

	private Pessoa validaPessoa(Pessoa pessoa) {
		if(pessoa == null) {
			throw new IllegalArgumentException("Pessoa esta null");
		}
			else if(pessoa.getNome() == null ||  pessoa.getNome().equals("")) {
				throw new IllegalArgumentException("Nome da pessoa esta invalida");
			}
			else if(pessoa.getEndereco() == null ||  pessoa.getEndereco().equals("")) {
					throw new IllegalArgumentException("Endereco da pessoa esta invalida");
				}
				else
					return pessoa;
	}

	@Override
	public void remover(Integer idPessoa, String metodo) throws Exception{
		validaMetodo(metodo).remover(idPessoa);
	}

	@Override
	public Pessoa busca(Integer idPessoa, String metodo) {
		Pessoa pessoa = null;
		pessoa = bancoDadosLista.buscarListaPessoa(pessoa);
		return pessoa;
	}

	@Override
	public List<PessoaFisica> getPessoaFisicaList(String metodo) {
		List<PessoaFisica> pessoaFisicaList = new ArrayList<>();
		for (Pessoa pessoa : validaMetodo(metodo).buscarListaPessoa()) {
			if (pessoa instanceof PessoaFisica) {
				pessoaFisicaList.add((PessoaFisica) pessoa);
			}
		}
		return pessoaFisicaList;
	}

		@Override
	public String calculaSalario(String metodo) {
		StringBuilder retorno = new StringBuilder();
		for(PessoaFisica pessoaFisica : getPessoaFisicaList(metodo)) {
				Float totalSalario = 0f;
				if(pessoaFisica.getSalario() < 1000) {
					totalSalario = (float) ((pessoaFisica.getSalario() * 0.02) + pessoaFisica.getSalario());
				}
				else if(pessoaFisica.getSalario() < 3000) {
					totalSalario = (float) ((pessoaFisica.getSalario() * 0.04) + pessoaFisica.getSalario());
				}
				else {
					totalSalario = (float) ((pessoaFisica.getSalario() * 0.07) + pessoaFisica.getSalario());
				}
				retorno.append(pessoaFisica.getNome()).append(" salario total R$ ").append(totalSalario).append("\n");
			}
		return retorno.toString();
	}
}
