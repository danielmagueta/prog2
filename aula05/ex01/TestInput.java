package aula05.ex01;
import static java.lang.System.*;
import aula05.ex01.util.Input;

public class TestInput {
  
  static String MESSAGE =
    "This program requests several real values.\n" +
    "Try inserting numbers with invalid format or out of range.\n";
  
  public static void main(String[] args) {
    out.println(MESSAGE);
    
    while(true) {
    	try {
    		double x = Input.getDouble("Real value X? ");
    		out.println(x);
    		break;
    	}
    	catch(IllegalArgumentException e) {
    		out.println("Invalid input format!");
    	}
    }
    
    while(true) {
    	try {
    		double nota = Input.getDouble("Nota? ", 0.0, 20.0);
    	    out.println(nota);
    	    break;
    	}
    	catch(IllegalArgumentException e) {
    		out.println("Invalid input format!");
    	}
    }

    
    while(true) {
    	try {
    		double temp = Input.getDouble("Temperature (Celsius)? ",-273.15, Double.POSITIVE_INFINITY);
    		out.println(temp);
    		break;
    	}
    	catch(IllegalArgumentException e) {
    		out.println("Invalid input format!");
    	}
    }


    //double z = Input.getDouble("Nota? ", 0.0, -10.0);  // should fail!
    
  }
}
