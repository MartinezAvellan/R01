package br.com.webpoc.util;

public class Teste {


	public static void main(String[] args) {
		String v = removeChar("https://www.google.com.br/");
		System.out.println(v);
	}
	
	public static String removeChar(String entrada) {
       String retorno = entrada;
       int tamanho = entrada.length();
       String valor = entrada.substring(tamanho-1, tamanho);
       
       if(valor.equals("/")){
    	   retorno = entrada.substring(0, tamanho-1); 
       }
	   return retorno;
	}

		

}
