package br.com.webpoc.teste;

import java.lang.reflect.Method;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstantiateClass{
	
	@Autowired	
	public ServletContext context;
	
	public Object instantiate(String className) throws Exception {
		Object instantiateClass = null;
		Class<?> params[] = {};
		Object paramsObj[] = {};
		try { 
 
			  Class<?> childClass = Class.forName(AASCONSTANTES.PACKAGE+className);
			  Object childObject = childClass.newInstance();  
			  
			  Method childMethod = childClass.getMethod("doit", params);
			  Object returChildMethod = childMethod.invoke(childObject, paramsObj);
			
			  System.out.println("childObject é : "+ childObject);
			  System.out.println("returChildMethod é : "+ returChildMethod.toString());

		} catch (Exception e) {
			throw new Exception(e);
		}
		
		return instantiateClass;
	}
	
}