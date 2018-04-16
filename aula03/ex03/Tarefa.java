package aula03.ex03;
import aula03.ex01.Data;

public class Tarefa {
	
	private Data ini;
	private Data fim;
	private String texto;
	
	public Tarefa(Data ini, Data fim, String texto) {
		this.ini = ini;
		this.fim = fim;
		this.texto = texto;
	}
	
	public Data inicio() {
		return ini;
	}
	
	public Data fim() {
		return fim;
	}
	
	public String texto() {
		return texto;
	}
	
	public String toString() {
		return inicio() + " --- " + fim() + ": " + texto();
	}
	
	public boolean intersecta(Tarefa t) {
		Data d1_i = this.inicio();
		Data d1_f = this.fim().dataseguinte();
		Data d2_f = t.fim().dataseguinte();
		
		while (!(d1_i.equals(d1_f))) {
			Data d2_i = t.inicio();
			while (!(d2_i.equals(d2_f))) {
				if (d1_i.equals(d2_i)) {return true;}
				d2_i = d2_i.dataseguinte();
			}
			d1_i = d1_i.dataseguinte();
		}
		return false;
	}
	
	/*public boolean intersecta(Tarefa t) {
		Data d1_i = this.inicio();
		Data d1_f = this.fim();
		Data d2_f = t.fim();
		d1_f.seguinte();
		d2_f.seguinte();
		
		System.out.println(d2_f);
		
		
		while (!(d1_i.equals(d1_f))) {
			Data d2_i = t.inicio();
			while (!(d2_i.equals(d2_f))) {
				if (d1_i.equals(d2_i)) {return true;}
				d2_i.seguinte();
			}
			d1_i.seguinte();
		}
		return false;
	}*/

}
