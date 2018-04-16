package aula06.ex05;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ListRec {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
		

		File filein;
		String dir;
		
		while(true) {
			try {
				assert args.length == 0 || args.length == 1;
				if(args.length == 1){
					dir = args[0];
				}
				else {
					dir = System.getProperty("user.dir");
				}
				filein = new File(dir);
				assert filein.isDirectory();
				break;
			}
			catch(Throwable e){
				System.out.println("Introduza directório pretendido: ");
				args = new String[1];
				args[0] = sc.nextLine();
			}
		
		}
		
		printD(filein, filein.getPath());
		


			
	}
	
	public static void printD(File f, String ff) {
		File lista[] = f.listFiles();
		int num = lista.length;
		for	(int i = 0; i < num; i++) {
			System.out.print(".");
			System.out.println(lista[i].getPath().replace(ff, ""));
			if(!lista[i].isFile()) {
				printD(lista[i], ff);
			}
		}
	
	}
		

}