package aula01;
import java.util.*;

public class ex3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduza um número: ");
		
		int x = sc.nextInt();
		
		if (isPrime(x)) {System.out.println("O número introduzido é primo.");}
		else {System.out.println("O número introduzido não é primo.");}
		sc.close();
		
	}
	
	public static boolean isPrime(int x) {
		int i = 0;
		int cont = 0;
		for (i = 1;i<=x;i++) {
			if (x%i == 0) {cont ++;}
		}
		if (cont == 2) return true;
		
		return false;
	}

}
