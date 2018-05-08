package aula09.ex07;
import static java.lang.System.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import aula09.p2utils.LinkedList;
import java.io.IOException;
import java.io.PrintWriter;

import static aula09.ex05.ListSort.*;


public class GetWords
{
  public static void main(String[] args) throws FileNotFoundException {
    if (args.length < 1) {
      err.println("Usage: java GetWords <file> ...");
      exit(1);
    }
    
    LinkedList<String> ll = new LinkedList<String>();
    String[] words;
    String[] wordsfromthepast;
    int count = 0;
    
    File f = new File("aula09/ex07/words.txt");
    wordsfromthepast = extractWords(f);
    for(int i = 0; i < wordsfromthepast.length; i++) {
      if(!ll.contains(wordsfromthepast[i])) {
    	ll.addLast(wordsfromthepast[i]);
    	count++;
      }
    }
    
    
    for(String s: args) {
    	
	    File fin = new File(s);
	    words = extractWords(fin);
	    for(int i = 0; i < words.length; i++) {
	      if(!ll.contains(words[i])) {
	    	ll.addLast(words[i]);
	    	count++;
	      }
	    }
    }
    quickSort(ll);
    String[] wordsdone = new String[ll.size()];
    int j = 0;
    while(ll.size()>0) {
    	wordsdone[j] = ll.first();
    	ll.removeFirst();
    	j++;
    }
    
    File fileout = new File("aula09/ex07/words.txt");
    PrintWriter pwf = new PrintWriter(fileout);
    
    for(int i = 0; i < wordsdone.length; i++) {
        out.printf("[%05d] %s\n", i+1, wordsdone[i]);
        pwf.println(wordsdone[i]);
    }
    out.println("Number of distint words: " + count);
    pwf.flush();
    pwf.close();
    
    
  }


  // Read words from a file, return words in an array
  @SuppressWarnings("resource")
static String[] extractWords(File fin) {
    try {
      // count the words
      int n = 0;
      Scanner scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
      // (words are delimited by 1 or more punctuation or whitespace char)
      while (scf.hasNext()) {
        scf.next();
        n++;
      }
      scf.close();

      // create the array
      String[] result = new String[n];

      // read the words
      int i = 0;
      scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
      while (scf.hasNext()) {
        result[i] = scf.next();
        i++;
      }
      scf.close();

      return result;
    }
    catch (IOException e) {
      err.printf("Error: %s\n", e);
      exit(1);
      return null;  // never happens...
    }
  }

}
