package aula03.ex04;
import aula03.ex01.Data;
import aula03.ex03.Tarefa;;

public class Agenda {
	
	private int n;
	private Tarefa tarefas[];
	
	public Agenda() {
		tarefas = new Tarefa[1000];
		n = 0;
	}
	
	public void novaTarefa(Tarefa t) {
		tarefas[n] = t;
		n++;
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				int c = tarefas[j].inicio().compareTo(tarefas[i].inicio());
		    	if (c < 0) {
		    		Tarefa tmp = tarefas[j];
		    		tarefas[j] = tarefas[i];
		    		tarefas[i] = tmp;
		        }
			}
		}
	}
	
	public void escreve() {
		for(int i = 0; i < n; i++) {
			System.out.println(tarefas[i]);
		}
	}
	
	public Agenda filtra(Data d1, Data d2) {
		Tarefa teste = new Tarefa(d1,d2,"teste");
		Agenda nova = new Agenda();
		for(int i = 0; i < n; i++) {
			if(tarefas[i].intersecta(teste)) {
				nova.novaTarefa(tarefas[i]);
			}
		}
		return nova;
	}
	
	
	
	

}
