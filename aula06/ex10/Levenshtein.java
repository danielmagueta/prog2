package aula06.ex10;
import static java.lang.System.*;

public class Levenshtein
{
  public static void main(String[] args) {
    if (args.length != 2) {
      out.println("Uso: java -ea Levenshtein <palavra1> <palavra2>");
      exit(1);
    }

    int d = distancia(args[0], args[1]);
    out.printf("\"%s\" <-> \"%s\" = %d\n", args[0], args[1], d);
  }
  
  public static int distancia(String p1, String p2) {
		
		if (p2.length() == 0) {
			return p1.length();
		}
		else if(p1.length() == 0) {
			return p2.length();
		}
		
		assert !(p1.isEmpty() && p2.isEmpty());
		
		if(p1.charAt(0) == p2.charAt(0)) {
			return distancia(p1.substring(1), p2.substring(1));
		}
		else {
			return 1 + min(distancia(p1.substring(1), p2), distancia(p1, p2.substring(1)), distancia(p1.substring(1), p2.substring(1)));
		}
		
	}
  
  	public static int min(int d1, int d2, int d3) {
  		
  		int lista[] = new int[] {d1,d2,d3};
  		int minimo = Integer.MAX_VALUE;
  		for(int i = 0; i < 3; i++) {
  			if(lista[i] < minimo) {
  				minimo = lista[i];
  			}
  		}
  		return minimo;
  	}

}
