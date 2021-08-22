package Aula02;

//Codigo sujo

public class CalculadoraPag {
 
 float resu = 0; // resultado final
 public CalculadoraPag(String nome, int idade,
         String dataNascimento,float salario){
     Funcionario f = new Funcionario();
     f.dt = dataNascimento;
     f.idade = idade;
     f.no = nome;
     f.s = salario;    
		try{
			validaFuncionario(f);
		}catch(Exception i){
			System.out.println("errro na validação");
		}
     resu = calcula(f);
 }
 
	void validaFuncionario(Funcionario f) throws Exception{
		if(f.no.equals("") || f.idade ==0){
			throw new Exception("error funcionario");
		}
	}
	
 public float retornaCalculoFuncionario(){
     return resu;
 }
 // esse metodo calcula o salario do funcionario
 private float calcula(Funcionario f){
		
		
     float r = 0;
     if(f.s < 1000){
         r = (f.s * 0.1f) + f.s;
     }
     if(f.s > 1000){
         r = (f.s * 0.2f) + f.s;
     }
     
     return r;        
 }
 
}