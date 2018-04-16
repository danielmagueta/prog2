package aula04.ex02;
import aula04.ex01.Data;

public class Tarefa {
	
	private Data ini;
	private Data fim;
	private String texto;
	
	public Tarefa(Data ini, Data fim, String texto) {
		assert fim.compareTo(ini) > 0 : "Data final menor que a inicial";
		assert texto.length()>0 : "Texto inválido!";
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
	
	

}
