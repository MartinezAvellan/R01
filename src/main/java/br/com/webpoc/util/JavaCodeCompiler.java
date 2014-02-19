package br.com.webpoc.util;

import java.util.Arrays;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.sun.org.apache.xalan.internal.xsltc.compiler.CompilerException;


public class JavaCodeCompiler<T> {
	
	private JavaCompiler compiler;
	private AppFileManager fileManager;
	private AppClassLoader classLoader;
	private DiagnosticCollector<JavaFileObject> diagnostics;

	public void Compiler() throws CompilerException {
		compiler = ToolProvider.getSystemJavaCompiler();
		if (compiler == null) {
			throw new CompilerException("Compilador não encontrado");
		}

		classLoader = new AppClassLoader(getClass().getClassLoader());
		diagnostics = new DiagnosticCollector<JavaFileObject>();

		StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(diagnostics, null, null);
		fileManager = new AppFileManager(standardFileManager, classLoader);
	}

	public synchronized Class<T> compile(String packageName, String className,
			String javaSource) throws CompilerException {
		try {
			String qualifiedClassName = CompilerUtils.getQualifiedClassName(packageName, className);
			AppJavaFileObject sourceObj = new AppJavaFileObject(className, javaSource);
			AppJavaFileObject compiledObj = new AppJavaFileObject(qualifiedClassName);
			fileManager.setObjects(sourceObj, compiledObj);
			CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null, Arrays.asList(sourceObj));
			boolean result = task.call();

			if (!result) {
				throw new CompilerException("A compilação falhou");
			}

			Class<T> newClass = (Class<T>) classLoader.loadClass(qualifiedClassName);
			return newClass;

		} catch (Exception e) {
			throw new CompilerException(e);
		}
	}
}