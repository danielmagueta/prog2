package GTA.E06;

public class P2
{
  public static void main(String[] args)
  {
	  for (String s: args) {
		  int result = countPairs('\0',0,s);
		  String result_s = "\"" + s + "\"" + " contains " + result + " pairs of consecutive equal characters";
		  System.out.println(result_s);
	  }
  }
  
  public static int countPairs(char c, int ind, String s) {
	  int count = 0;
	  if(ind != s.length()) {
		  char ch = s.charAt(ind); 
		  ind++;
		  if(ch == c) {
			  count++;
		  }
		  count += countPairs(ch,ind,s);
	  }
	  return count;
	  
  }

}

