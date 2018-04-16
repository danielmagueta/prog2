package aula01;
import java.util.*;

public class ex6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Adivinha o Número!");
		
		int random = (int)(Math.random()*(100+1));
		int tentativas = 0;
		int num = 0;
		
		do {	
			System.out.println("Introduza um número entre 0 e 100: ");
			num = sc.nextInt();
			tentativas ++;
			if (num>random) {System.out.println("O número é menor!");}
			else if(num<random) {System.out.println("O número é maior");}
			else {
				System.out.println("Acertou! O número era " + random + "!");
				System.out.println("Pontuação: " + tentativas);}
			
			
		}while(num != random);
		
		sc.close();
	}

}
