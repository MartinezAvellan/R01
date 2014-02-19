package br.com.webpoc.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.tools.SimpleJavaFileObject;

public class AppJavaFileObject extends SimpleJavaFileObject {
	private String source;
	private ByteArrayOutputStream byteCode = new ByteArrayOutputStream();

	public AppJavaFileObject(String baseName, String source) {
		super(CompilerUtils.createURI(CompilerUtils
				.getClassNameWithExt(baseName)), Kind.SOURCE);
		this.source = source;
	}

	public AppJavaFileObject(String name) {
		super(CompilerUtils.createURI(name), Kind.CLASS);
	}

	public String getCharContent(boolean ignoreEncodingErrors) {
		return source;
	}

	public OutputStream openOutputStream() {
		return byteCode;
	}

	public byte[] getBytes() {
		return byteCode.toByteArray();
	}
}
