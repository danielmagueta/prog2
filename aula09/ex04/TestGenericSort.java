// This program should use the generic mergeSort method in p2utils.Sorting
// to sort its string arguments.

package aula09.ex04;
import static aula09.p2utils.Sorting.*;


public class TestGenericSort{
	
	
	static public void main(String[] args) {
		
		String[] array = new String[args.length];
		int i = 0;
		
		for(String s : args) {
			array[i] = s;
			i++;
		}
		
		mergeSort(array, 0, array.length);
		
		System.out.print("[");
		
		for(int j = 0; j < array.length; j++) {
			System.out.print(array[j]);
			if(j < array.length-1) {
				System.out.print(", ");
			}
		}
		
		System.out.println("]");
		
		
  	
	}


	
}


