package aula05.ex05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class CutColumn {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException  {
		
		File filein;
		int n;
		
		while(true) {
			try {
				assert args.length == 2;
				filein = new File(args[0]);
				assert filein.exists() && filein.isFile();
				n = Integer.parseInt(args[1]);
				assert n >0;
				break;
			}
			catch(NumberFormatException e){
				System.out.println("Introduza um inteiro maior que 0 para indicara  coluna a ser lida: ");
				args[1] = sc.nextLine();
			}
			
			catch(Throwable e){
				System.out.println("Usage: java -ea CutColumn <source-file> <column-number>\n");
				System.out.println("Introduza ficheiro pretendido: ");
				args = new String[2];
				args[0] = sc.nextLine();
				System.out.println("Introduza coluna pretendida: ");
				args[1] = sc.nextLine();
			}
			
		}
		
		Scanner s = new Scanner(filein);
		Scanner s2;
		String ss;
		
		while(true) {
			try {
				while(s.hasNextLine()) {
					ss = s.nextLine();
					s2 = new Scanner(ss);
					int i = 0;
					while(i!=n-1) {
						s2.next();
						i++;
					}
					System.out.println(s2.next());
					s2.close();
				}
				break;
			}
			catch(NoSuchElementException e){
				System.out.println("");
			}
		}
		
		s.close();
			
		
		
		

	}

}
