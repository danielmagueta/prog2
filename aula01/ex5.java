package aula01;
import java.util.*;

public class ex5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		int x = 0;
		int count = 0;
		double media = 0;
		int soma = 0;
		
		do {
			System.out.println("Introduza um número: ");
			x = sc.nextInt();
			if (x != 0) {
				numeros.add(x);
				count ++;
			}
		}
		while(x!=0); 
		
		for (int i = 0; i<numeros.size();i++) {
			soma += numeros.get(i);
		}
		
		if(soma != 0) {media = soma/count;}
		
		System.out.println("Soma :" + soma);
		System.out.println("Média: " + media);
		sc.close();
	}

}
