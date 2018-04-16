package aula05.ex03;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class CopyFile {

	public static void main(String[] args) throws FileNotFoundException {
		
	
		Scanner sc = new Scanner(System.in);
		String file1;
		String file2;
		
		while(true) {
			try{
				assert args.length == 2 : "Deve indicar como argumentos o ficheiro a copiar e o ficheiro que será a cópia";
				file1 = args[0]; 
				file2 = args[1];
				break;
			}
			catch(Throwable e){
					System.out.println("Devem ser introduzidos 2 argumentos!");
					System.exit(1);
				}
			}
		
		File filein = null;
		File fileout = null;
		
		while(true) {
			try {
				filein = new File(file1);
				assert filein.exists();
				assert filein.canRead();
				assert filein.isFile();
				break;
			}
			catch(Throwable e){
				System.out.println("Erro, o ficheiro deve existir, ser possível de ler e ser normal!");
				System.out.println("Indique o ficheiro de texto a copiar: ");
				file1 = sc.nextLine();
			}
			
		}
		
		while(true) {
			try {
				fileout = new File(file2);
				if (fileout.exists()) {
					assert fileout.canWrite();
					System.out.println("O ficheiro de saída já existe, deseja apagá-lo e criar um novo?");
					System.out.println("0 - Não   1 - Sim");
					int x = sc.nextInt();
					if (x == 0) {System.exit(0);}
				}
				break;
			}
			catch(Throwable e){
				System.out.println("Erro, se o ficheiro já existir, deve ser possível escrever nele!");
				System.out.println("Indique o ficheiro de texto de cópia: ");
				file2 = sc.nextLine();
			}
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