package GTA.E04;

public class Invert {
	
	public static void main (String[] args) {
		
	
		for (String s :args) {
			String s_i = invertDigits(s,0);
			System.out.println(s_i);
			
		}
		
	}
	
	
	public static String invertDigits(String s, int inicio) {
		
		if(s.length()<=inicio+1) {return s;}
		
		int primeiro = s.length(), segundo = s.length()-1;
		int flag1 = 0, flag2 = 0;
		for(int i = inicio; i < s.length(); i++) {
			char c = s.charAt(i);
			if(isDigit(c) && i == (s.length()-1) && flag2 == 0) {
				segundo = i;
			}
			if(!isDigit(c) && flag1 == 1 && flag2 == 0) {
				segundo = i-1;
				flag2= 1;
			}
			if(isDigit(c) && flag2 == 0 && flag1 == 0) {
				flag1 = 1;
				primeiro = i;
			}
		}

		if(flag1 == 1) {
			if(primeiro < s.length() && segundo < s.length()) {
			s = tradeChar(s,primeiro,segundo);
			}
				if(segundo+1 < s.length()) {
					s = invertDigits(s,segundo+1);
				}
		}
		
		return s;
		
	}
		
		
	public static boolean isDigit(char c) {
		char a = '0';
		char b = '9';
		int ascii_0 = (int) a;
		int ascii_9 = (int) b;
		if (c>= ascii_0 && c <= ascii_9) {return true;}
		else {return false;}
	}
	
	public static String tradeChar(String s,int pos1,int pos2) {
		char[] ccopy = new char[s.length()];
		int num = 0;
		if((pos2-pos1)%2 == 0) {num = ((pos2-pos1+1)/2)+1;}
		else {num =((pos2-pos1+1)/2);}
		for (int i = 0; i<pos1; i++) {
			ccopy[i] = s.charAt(i);}
		for (int i = pos2+1; i<s.length(); i++) {
			ccopy[i] = s.charAt(i);}
		for(int j = num; j>0; j--) {
			ccopy[pos1] = s.charAt(pos2);
			ccopy[pos2] = s.charAt(pos1);
			pos2--;
			pos1++;
		}

		String scopy = new String(ccopy);
		return scopy;
	}
}

 