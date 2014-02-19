package br.com.webpoc.teste;

public class MakeTodayClass {
	
	static String className = "Amora";

	public static void main(String args[]) throws Exception {
		CreateClass createClass = new CreateClass();
		CompileClass compileClass = new CompileClass();
		InstantiateClass instantiateClass = new InstantiateClass();
		createClass.create(className);
		if (compileClass.compile(className)) {
			System.out.println("Executando " + className + ":\n");
			instantiateClass.instantiate(className);
		} else{
			System.out.println(className + " não compilou.");
		}
	}


}
