package aula06.ex08;



public class MDC {

	public static void main(String[] args) {
		
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int result = calc_mdc(a, b);
		System.out.println("MDC(" + a + ", " + b + ") = " + result);

	}
	
	public static int calc_mdc(int a, int b) {
		int mdc = 0;
		if(b == 0) {
			mdc = a;
		}
		else {
			mdc = calc_mdc(b,a%b);
		}
		return mdc;
	
	}

}
