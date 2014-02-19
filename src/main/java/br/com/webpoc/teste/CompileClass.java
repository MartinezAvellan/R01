package br.com.webpoc.teste;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.tools.javac.Main;

@Service
public class CompileClass {
	
	@Autowired	
	public ServletContext context;
	
	public boolean compile(String className) { 
		boolean retorno = false;
		String[] optionsAndSources = {new String(className+".java")};
		try{
			PrintWriter out = new PrintWriter( new FileWriter( "C:\\saidaCompilacao.txt" ) );
			int status = Main.compile( optionsAndSources, out );
			System.out.println( "status: " + status );
			retorno = true;
		} catch(IOException e){
			System.err.println("The file cannot be opened "+e);
		}
		return retorno;
	}

}
