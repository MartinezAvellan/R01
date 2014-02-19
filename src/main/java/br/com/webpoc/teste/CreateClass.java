package br.com.webpoc.teste;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateClass {
	
	@Autowired	
	public ServletContext context;
	
	public void create(String className) throws Exception {
		try {
			FileWriter fw = new FileWriter(new File(AASCONSTANTES.URL+className+".java"));
			BufferedWriter aWriter = new BufferedWriter(fw);  
			
			aWriter.write(" \n\n ");
			aWriter.write(" package br.com.webpoc.teste;");
			aWriter.write(" \n\n ");
			aWriter.write("public class " + className + " {\n\n");
			aWriter.write(" \n\n ");
			aWriter.write("\t\t public " + className + "(){} ");
			aWriter.write(" \n\n ");	
			aWriter.write("\t\t public String doit(){ \n\n");
			aWriter.write("\t\t\t\t return \""+className+"\";  \n\n ");
			aWriter.write("\t\t } ");
			aWriter.write(" } \n\n");
			aWriter.write(" \n\n ");
			
			aWriter.flush();
			aWriter.close();
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}


}
