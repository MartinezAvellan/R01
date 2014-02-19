package br.com.webpoc.util;

public class Compiler {

	public static void main(String[] args) throws Exception {

		JavaCodeCompiler<Runnable> compiler = new JavaCodeCompiler<Runnable>();   
	    String source = 
	      "public class RunnableImpl implements Runnable { " +
	      "  public void run() { System.out.println " +
	      " (\"Compilou!\"); } " +
	      "}";   
	    Class<Runnable> clazz = compiler.compile(null, "RunnableImpl", source);
	    Runnable r = clazz.newInstance();
	    r.run();
	  }

}
