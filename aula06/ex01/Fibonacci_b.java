package aula06.ex01;
import static java.lang.System.*;


import java.util.HashMap;


public class Fibonacci_b {

  public static void main(String[] args) {
    if (args.length < 1) {
      out.println("USO: java -ea Fibonacci N [N ...]");
      exit(1);
    }
    
    HashMap<Integer, Integer> ll = new HashMap<Integer, Integer>();
    
    
    
    // Alguns testes:
    assert fibonacci(0, ll) == 0;
    assert fibonacci(1, ll) == 1;
    assert fibonacci(2, ll) == 1;
    assert fibonacci(5, ll) == 5;

    for(int i = 0; i < args.length; i++) {
      int n = Integer.parseInt(args[i]);
      long time = nanoTime();  // System.nanoTime() gives the time in ns.
      int f;
      if(ll.containsKey(n)) {
    	  f = ll.get(n);
      }
      else {f = fibonacci(n, ll);}
      time = nanoTime() - time;
      out.printf("fibonacci(%d) = %d (%d ns)\n", n, f, time);
    }
  }

  public static int fibonacci(int n, HashMap<Integer, Integer> ll) {
    int result = 0;
	assert n >= 0;
    if(n == 1) {result = 1;}
    else if(n>1) {result = fibonacci(n-2, ll)+fibonacci(n-1, ll);} 
    if(!ll.containsKey(n))
    	{ll.put(n, result);}
    return result;
  }
  
  
  

}