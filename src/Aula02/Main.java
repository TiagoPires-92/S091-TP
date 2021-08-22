package Aula02;

public class Main {

	public static void main(String[] args) {
		CalculadoraPag c = new CalculadoraPag("maria",
                     30, "26/06/1990", 500);
             float ret = c.retornaCalculoFuncionario();
             System.out.println("salário: " + ret);
	}

}
