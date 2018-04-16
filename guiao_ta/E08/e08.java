package GTA.E08;

public class e08 {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		int den = Integer.parseInt(args[1]);
		Fraction f = new Fraction(num,den);
		System.out.println(f + " = " + decomposta(f,0));
	}
	
	public static String decomposta(Fraction f, int flag) {
		String s = "";
		if(f.equals(Fraction.ZERO)) {return s;}
		if(flag ==1) {
			s = " + ";
		}
		Fraction unitaria, resto = null;
		if(f.num()!=1 && f.num() != 0) 
		{
			
			double d = f.den();
			double n = f.num();
			int n_den = (int) Math.ceil(d/n);
			unitaria = new Fraction(1,n_den);
			resto = f.subtract(unitaria);
			s += unitaria;
			s += decomposta(resto, 1);
		}
		else {
			return s += f.toString();}
		return s;
	}
}
