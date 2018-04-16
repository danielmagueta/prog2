package aula01;
import java.util.*;


public class ex2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nota TP: ");
		double tp = sc.nextDouble();
		System.out.println("Nota PG1: ");
		double pg1 = sc.nextDouble();
		System.out.println("Nota PG2: ");
		double pg2 = sc.nextDouble();
		System.out.println("Nota EF: ");
		double ef = sc.nextDouble();
		
		double nf = 0.2*tp + 0.15*pg1 + 0.15*pg2 + 0.5*ef;
		
		System.out.println("Nota Final: " + nf);
		sc.close();
	}

}
