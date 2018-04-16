package aula06.ex09;


public class Loan {

	public static void main(String[] args) {
		int meses = Integer.parseInt(args[0]);
		double money = Double.parseDouble(args[1]);
		double taxa = Double.parseDouble(args[2]);
		double prestação = Double.parseDouble(args[3]);
		double result_it = emprestimo_it(meses, money, taxa, prestação);
		System.out.println("(iterativo) d(" + meses + ") = " + result_it);
		double result_rc = emprestimo_rc(meses, money, taxa, prestação);
		System.out.println("(recursivo) d(" + meses + ") = " + result_rc);

	}
	
	
	
	
	public static double emprestimo_it(int meses, double money, double taxa, double prestação ) {
		
		double result = money;
		for(int n = meses; n>0; n--) {
			double aux = (result * (taxa/100)) + result;
			result = aux - prestação;
		}
	
		return result;
	}
	
	
	public static double emprestimo_rc(int meses, double money, double taxa, double prestação ) {
		
		double result = 0;
		if(meses !=0) {
			double aux = (money * (taxa/100)) + money;
			result = aux - prestação;
			result = emprestimo_rc(meses-1, result, taxa, prestação);
		}
		else {return money;}
		return result;
	}

}
