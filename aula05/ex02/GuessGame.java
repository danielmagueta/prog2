package aula05.ex02;
import static java.lang.System.*;

public class GuessGame {

  public int secretNumber; // to hold the secret
  private int min;
  private int max;
  public int attempt;
  private int numattempts;

  public GuessGame(int min, int max) {
    this.min = min;
    this.max = max;
	this.secretNumber = (int) ((Math.random()*(max-min)) + min);  
    assert secretNumber>=min && secretNumber<=max : "Número fora do domínio";
    this.attempt = Integer.MAX_VALUE;
  }

  public int min() {
	 return min;
  }

  public int max() {
    return max;
  }

  public boolean validAttempt(int n) {
    if(n>=min && n<=max) return true;
    return false;
  }

  public boolean finished() {
    if(attempt == secretNumber) return true;
    return false;
  }

  public boolean attemptIsHigher() {
    if(attempt>secretNumber) return true;
    return false;
  }

  public boolean attemptIsLower() {
	 if(attempt<secretNumber) return true;
	 return false;
  }

  public void play(int n) {
    this.attempt = n;
    numattempts++;
  }

  public int numAttempts() {
    return numattempts;
  }

  /**
   * Simple tests of the GuessGame class.
   * This method tests the functionality of the GuessGame class.
   * It should be used by the programmer to test and debug the class.
   * It is not meant to be called in client programs.
   *
   * To run from the command line, use:
   *   java -ea GuessGame
   */
  public static void main(String[] args) {
    requireEA();
    out.println("Starting tests.");
    GuessGame game = new GuessGame(1, 10);
    // initial tests:
    assert !game.finished() : "game should not be finished yet";
    assert game.min() == 1;
    assert game.max() == 10;
    assert game.numAttempts() == 0 : "there should be no attempts yet";
    for(int i = -10; i <= 20; i++) {
      assert game.validAttempt(i) == (i >= 1 && i <= 10);
    }
    // trying all wrong answers:
    int nplay = 0; // how may times play was called
    for(int n = 1; n <= 10; n++) {
      if (n != game.secretNumber) {
        game.play(n); // make a wrong guess
        nplay++;
        assert game.numAttempts() == nplay;
        assert !game.finished() : "game should not be finished yet";
        assert (n < game.secretNumber) == game.attemptIsLower();
        assert (n > game.secretNumber) == game.attemptIsHigher();
      }
    }
    // make the right guess:
    game.play(game.secretNumber);
    nplay++;
    assert game.finished() : "game should be finished now";
    assert game.numAttempts() == nplay;
    out.println("No error detected!");
  }

  /** Check if program is being run with -ea, exit if not. */
  static void requireEA() {
    boolean ea = false;
    assert ea = true; // assert with a side-effect, on purpose!
    if (!ea) {
      err.println("This program must be run with -ea!");
      exit(1);
    }
  }

}

