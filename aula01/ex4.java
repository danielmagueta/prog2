package aula01;
import java.util.*;

public class ex4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduza uma frase: ");
		
		String frase = sc.nextLine();
		
		String frasefinal = "";
		
		
		for(int i = 0; i < frase.length(); i ++) {
			
			if(frase.charAt(i) == 'l') {
				frasefinal += 'u';
			}
			else if(frase.charAt(i) == 'L') {
				frasefinal += 'U';
			}
			else if (frase.charAt(i) != 'r' && frase.charAt(i)!= 'R') {
				frasefinal += frase.charAt(i);
			}
		}

		System.out.println("Frase Traduzida: " + frasefinal);
		sc.close();
	}

}
