package br.com.webpoc.util;

public class ClassGenerics {
	

	public String metodoAsa(){
		return "Metodo Asa!";
	}
	
	public String metodoASA(String nome){
		return "Metodo Asa com parametro nome: "+ nome;
	}
	

	public class Teste{
		public String metodoTeste(){
			return "Metodo teste!";
		}
		
		public String metodoTeste(String nome){
			return "Metodo teste com parametro nome: "+ nome;
		}
	}

}
