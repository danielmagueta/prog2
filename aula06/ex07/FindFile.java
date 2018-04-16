package aula06.ex07;

import java.io.File;

public class FindFile {

	public static void main(String[] args) {
		
		String texto = args[0];
		String dir = System.getProperty("user.dir");
		File f = new File(dir);
		printD(f, texto);
		
	}
	
	public static void printD(File f, String ff) {
		File lista[] = f.listFiles();
		int num = lista.length;
		for	(int i = 0; i < num; i++) {
			String name = lista[i].getName();
			if(name.indexOf(ff) >= 0) {
				System.out.println(lista[i].getPath());
			}
			if(!lista[i].isFile()) {
				printD(lista[i], ff);
			}
		}
	
	}
		
	

}
