package aula02;
public class DatasPassadas {

	public static void main(String[] args) {
		
		Data actual = new Data();
		Data natal;
		
		if(actual.mes() <12 || actual.dia() < 25) {
			natal = new Data(25, 12, actual.ano()-1);
		}
		else {
			natal = new Data(25, 12, actual.ano());
		}
		
		actual.seguinte();
		
		
		while (!natal.equals(actual)){
			System.out.println(natal.extenso());
			natal.seguinte();
		}
		
		
		

	}

}
