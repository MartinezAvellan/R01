package br.com.webpoc.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ChamaClasssePorReflection {


	private static void MetodoUm() throws ClassNotFoundException,InstantiationException, IllegalAccessException,NoSuchMethodException, InvocationTargetException {
		Class<?> motherClass = Class.forName("br.com.webpoc.util.ClassGenerics");
		Object motherObject = motherClass.newInstance();
		
		Method motherMethod = motherClass.getMethod("metodoAsa");
		Object returnMotherMethod = motherMethod.invoke(motherObject);
		

		
		Class<?> childClass = Class.forName("br.com.webpoc.util.ClassGenerics$Teste");
		Constructor<?> constructor = childClass.getDeclaredConstructor(motherClass);

		Object childObject = constructor.newInstance(motherObject);
		
		Method childMethod = childClass.getMethod("metodoTeste");
		Object returChildMethod = childMethod.invoke(childObject);
		
		System.out.println("motherObject � : "+ motherObject);
		System.out.println("returnMotherMethod � : "+ returnMotherMethod.toString());
		
		System.out.println("childObject � : "+ childObject);
		System.out.println("returChildMethod � : "+ returChildMethod.toString());
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		MetodoUm();
	}
}
