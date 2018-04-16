package aula01;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ex7 {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Cópia de ficheiro de texto.");
		System.out.println("Modo de utilização:");
		System.out.println("Nome Ficheiro a Copiar  (space)  Nome da Cópia");
		Scanner sc = new Scanner(System.in);
		
		String file1 = sc.next();
		String file2 = sc.next();
		
		File filein = new File(file1);
		File fileout = new File(file2);
		
		if (fileout.exists()) {
			System.out.println("O ficheiro de saída já existe, deseja apagá-lo e criar um novo?");
			System.out.println("0 - Não   1 - Sim");
			int x = sc.nextInt();
			if (x == 0) {System.exit(0);}
		}
		
		
		Scanner fin = new Scanner(filein);
		PrintWriter fout = new PrintWriter(fileout);
		
		
		while (fin.hasNextLine()) {
			String temp = fin.nextLine();
			fout.println(temp);
		}
		
		
		fin.close();
		fout.flush();
		fout.close();
		sc.close();
	
		
		
		

	}

}
