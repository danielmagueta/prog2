package aula08.ex02;
import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;

public class SortInts
{
  public static void main(String[] args) throws IOException {
    
	  SortedListInt lista = new SortedListInt();
	  for(String s : args) {
		  File f = new File(s);
		  sorts(f, lista);
	  }
	  
	  int k = lista.size();
	  
	  for(int i = 0; i < k; i++) {
		  out.println(lista.get(i));
		  
	  }

  }
  
  @SuppressWarnings("resource")
public static void sorts(File f, SortedListInt sli) throws FileNotFoundException {
	  assert f.isFile() && f.exists();
	  Scanner ss = new Scanner(f);
	  while(ss.hasNext()) {
		  String n = ss.next();
		  try {
			  int num = Integer.parseInt(n);
			  sli.insert(num);
		  }
		  catch(Exception e){
			  
		  }
		  
	  }
  }

}


