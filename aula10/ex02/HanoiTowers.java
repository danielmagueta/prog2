package aula10.ex02;
import static java.lang.System.*;
import aula10.p2utils.Stack;

public class HanoiTowers
{
	
	private int n;
	private int moves;
	private Stack<Integer> a , b, c;
	
	public HanoiTowers(int n) {
		this.n = n;
		this.moves = 0;
		a = new Stack<Integer>();
		b = new Stack<Integer>();
		c = new Stack<Integer>();
		for(int i = n; i>0; i--) {
			a.push(i);
		}
	}
	
	public void state() {
		out.println("After " + numberOfMoves() + " moves:");
		out.println("A: " + a.reverseToString());
		out.println("B: " + b.reverseToString());
		out.println("C: " + c.reverseToString());
		out.println();
	}
	
	public void solve() {
		state();
		solve(this.n, this.a, this.c, this.b);
	}

	
	private void solve(int num, Stack<Integer> O, Stack<Integer> D, Stack<Integer> A) {
		assert num >= 0;
		if (num>0) {
			solve(num-1, O, A, D);
			moveDisk(O,D);
			state();
			solve(num-1, A, D, O);
		}
	}
	
	public void moveDisk(Stack<Integer> a, Stack<Integer> b) {
		int x = a.top();
		b.push(x);
		a.pop();
		moves++;
	};
	
	public int numberOfMoves() {
		return moves;
	}

}
