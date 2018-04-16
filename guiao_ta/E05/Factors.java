package GTA.E05;

public class Factors {

	public static void main(String[] args) {
		
		for (String s: args) {
			int n = Integer.parseInt(s);
			System.out.println(n + " = " + factors(n));
		}
		
	}
	
	public static String factors(int n) {
		String result = "";
		int factor = 0;
		int i = n-1;
		while(i>=2 && n%i!=0) {
			i--;
		}
		if(i>=2) {
			factor = n/i;
			result += factor + " * ";
			result += factors(i);
		}
		else {
			result = result += n;
		}
		return result;
	}
}
