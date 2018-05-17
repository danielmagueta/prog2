package aula10.ex01;
import java.util.Scanner;
import aula10.p2utils.*;

public class Palindrome {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		assert args.length == 1 : "Usage: java -ea Palindrome <text>";
		String s = new String();
		
		while(true) {
			try {
				s = args[0];
				break;
			}
			catch(Exception e) {
				System.out.println("Insira a frase pretendida: ");
				args[0] = sc.nextLine();
			}
		}
		
		s = s.toLowerCase();
		String nova = new String();
		Character ch;
		
		for(int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if(Character.isDigit(ch) || Character.isAlphabetic(ch)) {
				nova += ch;
			}
		}
		palindrome(nova);
		sc.close();
		
	}
	
	static void palindrome(String s) {
		assert s.length()>=2;
		Stack<Character> st = new Stack<Character>();
		Queue<Character> qe = new Queue<Character>();
		boolean result = false;
		Character ch;
		for(int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			st.push(ch);
			qe.in(ch);
		}
		while(!st.isEmpty()) {
			if(st.top().equals(qe.peek())) {
				st.pop();
				qe.out();
			}
			else {
				break;
			}
			result = true;
		}
		
		if(result) {System.out.println("É um palíndromo!");}
		
		
	}
	
	

}
