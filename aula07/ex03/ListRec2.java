package aula07.ex03;
import static java.lang.System.*;
import java.io.File;

import aula07.p2utils.LinkedList;

public class ListRec2 {

  public static void main(String[] args) {
    if (args.length != 1) {
      err.println("Uso: java -ea ListRec2 <dir>");
      exit(1);
    }

    File dir = new File(args[0]);

    // Verificar entrada
    if (!dir.exists()) {
      err.printf("ERRO: %s nao existe!\n", dir);
      exit(2);
    }

    LinkedList<File> files = recListFiles(dir);
    files.print();
  }

  /** Devolve uma lista com o conteúdo de um directório f
   *  e de todos os seus subdirectórios recursivamente.
   */
  public static LinkedList<File> recListFiles(File f) {
	  	LinkedList<File> result = new LinkedList<File>();
	  	File lista[] = f.listFiles();
		int num = lista.length;
			for	(int i = 0; i < num; i++) {
				result.addLast(lista[i]);
				if(!lista[i].isFile()) {
					File lista2[] = lista[i].listFiles();
					if(lista2.length > 0) {
						result = result.concatenate(recListFiles(lista[i])); //duvida
					}
				}
			}
		return result;
  }
}
