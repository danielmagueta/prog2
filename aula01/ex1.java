package aula01;
import java.util.*;

public class ex1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("----------------------Calculadora Simples-----------------------");
		System.out.println("######Utilização: 1º Número(space)Operador(space)2º Número######");
		System.out.println("Operadores: Soma-> + Subtração-> - Multiplicação-> * Divisão-> /");
		System.out.println("Introduza a conta a realizar: ");
		
		double a = sc.nextDouble();
		
		String op = sc.next();
		
		double b = sc.nextDouble(); 
		
		double resultado = 0;
		
		if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
			
			switch(op) {
			case "+":
				resultado = a+b;
				break;
			case "-":
				resultado = a-b;
				break;
			case "*":
				resultado = a*b;
				break;
			case "/":
				resultado = a/b;
				break;
			}
			
			System.out.println("Resultado: " + resultado);
			
		}
		else {
			System.err.println("Operador inválido!");
		}
		
		sc.close();
	
		
	}

}
