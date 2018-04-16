package aula05.ex04;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ListDir {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
		
		
		String filetxt;
		File filein;
		
		while(true) {
			try {
				assert args.length == 0 || args.length == 1;
				if(args.length == 1){
					filetxt = args[0];
					filein = new File(filetxt);
				}
				else {
					String dir = System.getProperty("user.dir");
					filein = new File(dir);
				}
				break;
			}
			catch(Throwable e){
				System.out.println("Mais que um diretório introduzido");
				System.out.println("Introduza directório pretendido: ");
				args = new String[1];
				args[0] = sc.nextLine();
			}
		
		}
		
		
		
		
		
		
		while(true) {
			try {
				assert filein.isDirectory();
				break;
			}
			catch(Throwable e) {
				System.out.println("Texto introduzido não corresponde a um diretório");
				System.out.println("Introduza de novo o diretório pretendido: ");
				String n = sc.nextLine();
				filein = new File(n);
			}
		}
		
		File lista[] = filein.listFiles();
		
		String a;
		
		for(File x: lista) {
			a = "";
			
			if(x.isFile()) {a += "F";}
			else if(x.isDirectory()){a+="D";}
			
			if(x.canRead()) {a += "R";}
			else {a+="-";}
			
			if(x.canWrite()) {a += "W";}
			else {a+="-";}
			
			a += "  " +    x.getPath().replace(filein.getPath(), "");
			System.out.println(a);
			
		}
		
		
		
		

	}

}
