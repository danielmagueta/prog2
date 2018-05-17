package aula10.ex04;
import java.util.InputMismatchException;
import java.util.Scanner;

import aula10.p2utils.*;

public class RPNCalculator {
	
	//como fechar o sc, deu unreachable
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack<Double> pilha = new Stack<Double>();
		double x,y, resultado;
		
		while(true) {
			try {
				Double arg = sc.nextDouble();
				pilha.push(arg);
			}
			catch(InputMismatchException e) {
				String c = sc.next();
				assert pilha.size() >= 2 : "ERROR: one operand missing!";
				x = pilha.top();
				pilha.pop();
				y = pilha.top();
				pilha.pop();
				
				switch(c) {
				case "+":
					resultado = x+y;
					pilha.push(resultado);
					break;
				case "-":
					resultado = x-y;
					pilha.push(resultado);
					break;
				case "*":
					resultado = x*y;
					pilha.push(resultado);
					break;
				case "/":
					resultado = x/y;
					pilha.push(resultado);
					break;
				default:
					System.out.println("ERROR: Invalid operator!");
					System.exit(0);
				}
			}
			System.out.print("Stack: ");
			System.out.println(pilha.reverseToString());
			
		}
		
	}

}
