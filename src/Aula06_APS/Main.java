package Aula06_APS;

import javax.swing.*;

public class Main {

	static PessoaServiceImpl pessoaService;

	public static void main(String[] args) {
		pessoaService = new PessoaServiceImpl();
		String metodo = null;

		//first dialog
		String inputDialogInit = JOptionPane.showInputDialog("Selecione a forma de armazenamento\n1.Lista\n2.Mapa");
		if(inputDialogInit.equals("1")) {
			metodo = "lista";
		}else if(inputDialogInit.equals("2")) {
			metodo= "map";
		}else {
			JOptionPane.showMessageDialog(null, "opcao invalida para salvamento");
			System.exit(1);
		}

		//second dialog
		while(true) {
			String inputDialog = JOptionPane.showInputDialog(menuPrincipa());
			if(inputDialog.equals("1")) {
				try {
				cadastroPessoaFisica(metodo);
				}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "erro ao salvar pessoa");
				}
			}else if(inputDialog.equals("2")) {
				try {
				cadastroPessoaJuridica(metodo);
				} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "erro ao salvar pessoa");
				}
			}else if(inputDialog.equals("3")) {
				mostraSalario(metodo);
			}else if(inputDialog.equals("4")) {
				try {
				remover(metodo);
				}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "erro ao remover pessoa");
				}
			}else if(inputDialog.equals("3")) {
				System.exit(1);
			}
		}
	}

	private static void remover(String metodo) throws  Exception {
		String idPessoa = JOptionPane.showInputDialog("Qual id da pessoa para remover");
		pessoaService.remover(Integer.parseInt(idPessoa), metodo);
	}

	private static void mostraSalario(String metodo) {
		JOptionPane.showMessageDialog(null, pessoaService.calculaSalario(metodo));
	}

	private static void cadastroPessoaJuridica(String metodo) throws Exception {
		String nomePessoaJuridica = JOptionPane.showInputDialog("Qual nome da empresa");
		String enderecoPessoaJuridica = JOptionPane.showInputDialog("Qual endereco da empresa");
		String cnpj = JOptionPane.showInputDialog("Qual cnpj da empresa");

		PessoaJuridica pessoaJuridica = new PessoaJuridica();

		pessoaJuridica.setEndereco(enderecoPessoaJuridica);
		pessoaJuridica.setNome(nomePessoaJuridica);
		pessoaJuridica.setCnpj(cnpj);

		pessoaService.salvaPessoaJuridica(pessoaJuridica, metodo);
	}

	private static void cadastroPessoaFisica(String método) throws Exception {
		String nomePessoaFisica = JOptionPane.showInputDialog("Qual nome da pessoa");
		String enderecoPessoaFisica = JOptionPane.showInputDialog("Qual endereco da pessoa");
		String cpf = JOptionPane.showInputDialog("Qual cpf da pessoa");
		String salario = JOptionPane.showInputDialog("Qual salario da pessoa");

		PessoaFisica pessoaFisica = new PessoaFisica();

		pessoaFisica.setCpf(cpf);
		pessoaFisica.setEndereco(enderecoPessoaFisica);
		pessoaFisica.setNome(nomePessoaFisica);
		pessoaFisica.setSalario(Float.parseFloat(salario));

		pessoaService.salvaPessoaFísica(pessoaFisica, método);
	}


	public static String menuPrincipa() {
		StringBuilder opcoes = new StringBuilder();
		opcoes.append("selecione uma opcao\n");
		opcoes.append("1. cadastro pessoa fisica\n");
		opcoes.append("2. cadastro pessoa juridica\n");
		opcoes.append("3. mostra salario pessoa fisica\n");
		opcoes.append("4. remover uma opcao\n");
		opcoes.append("5. sair\n");

		return opcoes.toString();
	}
}
