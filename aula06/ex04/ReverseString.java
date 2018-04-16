package aula06.ex04;
import static java.lang.System.*;

public class ReverseString {

  public static void main(String[] args) {
    printArray(args, args.length);
  }

  /** Imprime as N primeiras strings do array, uma por linha. */
  public static void printArray(String[] array, int N) {
    if(N!=0) {
    	printArray(array, N-1);
    	out.println("");
    	out.print("\"" + array[N-1] + "\"" +  " -> " + "\"" );
    	reverse(array[N-1], array[N-1].length());
    	out.print("\"");
    }
  }
  
  public static void reverse(String a, int aux) {
	  if(aux!=0) {
	  out.print(a.charAt(aux-1));
	  reverse(a,aux-1);
	  }
  }
	    
    

}