package com.anno.warriors.dw8.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileStreamHandler {

	private InputStream is;
	private String path;

	public FileStreamHandler(String path) throws FileNotFoundException {
		is = getClass().getClassLoader().getResourceAsStream(path);
		if (is == null) {
			throw new FileNotFoundException("File not found in resources folder");
		}
		if (path != null && path.contains("/")) {
			String[] split = path.split("/");
			this.path = split[split.length - 1].trim();
		} else {
			this.path = "";
		}
	}

	public String getFileName() {
		return this.path;
	}

	public BufferedReader getBufferedReader() {
		return new BufferedReader(new InputStreamReader(is));
	}

}
