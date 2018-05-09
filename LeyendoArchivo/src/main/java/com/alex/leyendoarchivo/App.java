package com.alex.leyendoarchivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		App obj = new App();
		System.out.println(obj.getFile("hola.txt"));
	}

	private String getFile(String nombreArchivo) {
		StringBuilder result = new StringBuilder();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(nombreArchivo).getFile());

		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return result.toString();
	}
}
