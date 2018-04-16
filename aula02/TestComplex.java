package aula02;
import static java.lang.System.*;
import java.util.*;

public class TestComplex {
  
	
  static Scanner sc = new Scanner(System.in);	
  public static void main(String[] args) {
    
	  double re, im;
	  
	 if (args.length>=2) {
		 re = Double.parseDouble(args[0]);
		 im = Double.parseDouble(args[1]); 
	 }
	 else {
		 System.out.println("Re: ");
		 re = sc.nextDouble();
		 System.out.println("Im: ");
		 im = sc.nextDouble();
	 }
	 
	 
	 Complex a = new Complex(re,im);

    // Vamos usar métodos do objeto a
    out.println("(" + a.real() + " + " + a.imag() + "i)");
    out.println("  parte real = " + a.real());
    out.println("  parte imaginaria = " + a.imag());
    out.println("  modulo = " + a.abs());
    out.printf("  argumento =  %2.2f\n", a.arg());
  }

}
