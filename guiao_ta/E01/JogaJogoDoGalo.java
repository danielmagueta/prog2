package GTA.E01;
import static java.lang.System.*;
import java.util.Scanner;


    
public class JogaJogoDoGalo {
  private static Scanner sin = new Scanner(in);
  
  public static void main(String[] args) {
   
	int maxjogos = 10;
	int numjogos = 0;
	int jganhosX = 0;
	int jganhosO = 0;
	
	do {
		char jogador1 = 'X';
	    char jogador2 = 'O';
	    JogoDoGalo jogo = new JogoDoGalo(jogador1, jogador2);
	    jogo.mostraTabuleiro();
	    
	    while (!jogo.terminado()) {
	      out.print("(lin col): ");
	      int lin = sin.nextInt();
	      int col = sin.nextInt();
	      jogo.jogada(lin, col);
	      jogo.mostraTabuleiro();
	    }
	    
	    out.println();
	    if (jogo.ultimoJogadorGanhou()) {
	      out.println("Jogador "+jogo.ultimoJogador()+" ganhou esta ronda!");
	      numjogos ++;
	      	if (jogo.ultimoJogador() == 'X'){jganhosX++;}
	      	else {jganhosO++;}
	      	out.println("Pontuação: Jogador X -> " + jganhosX + " Jogador O -> " + jganhosO);
	    } else {
	      out.println("Jogo empatado!");
	      numjogos ++;
	    }
	    
	    if(jganhosX == 3 || jganhosO == 3) {
	    	out.println("Jogador "+jogo.ultimoJogador()+" ganhou o jogo!");
	    }
	    
	}while(numjogos < maxjogos && jganhosX<3 && jganhosO<3);
  
  
	sin.close();
  }
}
