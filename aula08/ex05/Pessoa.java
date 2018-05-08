package aula08.ex05;
public class Pessoa implements Comparable<Pessoa>{
	
	private String nome;
	private Data d;
	
	public Pessoa(Data d, String nome) {
		this.d = d;
		this.nome = nome;
	}
	
	public Data getData() {
		return d;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String toString() {
		return "(" + d.toString() + ", " + nome + ")";
	}
	
	public int compareTo(Pessoa p) {
		if(this.getData().mes() < p.getData().mes()) {
			return -1;
		}
		else if(this.getData().mes() > p.getData().mes()) {
			return 1;
		}
		else if(this.getData().mes() == p.getData().mes()) {
			if(this.getData().dia() < p.getData().dia()) {
				return -1;
			}
			else if(this.getData().dia() > p.getData().dia()) {
				return 1;
			}	
		}
		return 0;
	}
}
