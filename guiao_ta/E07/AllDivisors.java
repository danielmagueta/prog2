package GTA.E07;
import static java.lang.System.*;

public class AllDivisors
{
	public static void main(String[] args) {
		for (String s: args) {
			String space = "";
			int n = Integer.parseInt(s);
			Divisors(space, n);
		}
	}

	
	public static void Divisors(String space, int n) {
		out.println(space + n);
		space += "  ";
		for(int i = 2; i<=n; i++) {
			if(n%i == 0 && n!= i) {
				Divisors(space,n/i);
			}
		}
	}
	
	
	
}

