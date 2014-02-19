package br.com.webpoc.util;

import java.io.IOException;
import java.nio.file.WatchEvent.Kind;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;

public class AppFileManager extends ForwardingJavaFileManager<JavaFileManager> {
	
	private AppClassLoader classLoader;
	private AppJavaFileObject sourceObject;
	private AppJavaFileObject compiledObj;

	public AppFileManager(JavaFileManager fileManager, AppClassLoader classLoader) {
		super(fileManager);
		this.classLoader = classLoader;
	}

	public void setObjects(AppJavaFileObject sourceObj,	AppJavaFileObject compiledObj) {
		this.sourceObject = sourceObj;
		this.compiledObj = compiledObj;
		this.classLoader.setCompiledObj(compiledObj);
	}

	public FileObject getFileForInput(Location location, String packageName, String relativeName) throws IOException {
		return sourceObject;
	}

	public JavaFileObject getJavaFileForOutput(Location location, String qualifiedName, Kind kind, FileObject outputFile)
			throws IOException {
		return compiledObj;
	}

	public ClassLoader getClassLoader(Location location) {
		return classLoader;
	}
}