package aula04.ex07;

public class teste {

	public static void main(String[] args) {
		Fraction a = new Fraction(300,99);
		System.out.println(a);
		int x = 0;
		if(a.simplified()) x=1;
		System.out.println(x);

	}
	

}
