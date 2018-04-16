package aula07.ex01;
import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;
// import java.util.*;   // => "error: reference to LinkedList is ambiguous"
// java.util.LinkedList colide com p2utils.LinkedList!
import aula07.p2utils.*;

public class FilterLines
{
  public static void main(String[] args) throws IOException
  {
    if (args.length != 1) {
      err.printf("Usage: java -ea FilterLines text-file\n");
      exit(1);
    }
    File fil = new File(args[0]);

    LinkedList<String> menos20 = new LinkedList<String>();
    LinkedList<String> inthemiddle = new LinkedList<String>();
    LinkedList<String> mais40 = new LinkedList<String>();

    Scanner sf = new Scanner(fil);
    // exceções poderiam ser intercetadas e mostrar mensagem de erro.
    while (sf.hasNextLine()) {
      String line = sf.nextLine();
      if (line.length()<20) {
    	  menos20.addLast(line);
      }
      else if(line.length()>40) {
    	  mais40.addLast(line);
      }
      else {inthemiddle.addLast(line);}

    }
    sf.close();

    // Escrever conteúdo das listas...
    out.println("Curtas---|---------|---------|---------|---------");
    menos20.print();

    out.println("Médias---|---------|---------|---------|---------");
    inthemiddle.print();

    out.println("Longas---|---------|---------|---------|---------");
    mais40.print();
  }

}
