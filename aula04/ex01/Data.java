package aula04.ex01;
import java.util.Calendar;

public class Data {
  private int dia, mes, ano;

  /** Inicia esta data com o dia de hoje. */
  public Data() {
    Calendar today = Calendar.getInstance();

    this.dia = today.get(Calendar.DAY_OF_MONTH);
    this.mes = today.get(Calendar.MONTH) + 1;
    this.ano = today.get(Calendar.YEAR);
  }
  
  public Data(String d) {
    String data[] = d.split("-");
    this.dia = Integer.parseInt(data[2]);
    this.mes = Integer.parseInt(data[1]);
    this.ano = Integer.parseInt(data[0]);
    if(!dataValida(dia,mes,ano)){
    	System.out.println("Data Inválida");
    	System.exit(0);}
 }  

  public int dia() {
	return dia;
}

public int mes() {
	return mes;
}

public int ano() {
	return ano;
}

/** Inicia a data a partir do dia, mes e ano dados. */
  public Data(int dia, int mes, int ano) {
	assert dataValida(dia, mes, ano);
	this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }

  /** Devolve esta data segundo a norma ISO 8601. */
  public String toString() {
    return String.format("%04d-%02d-%02d", ano, mes, dia);
  }

  /** Indica se ano é bissexto. */
  public static boolean bissexto(int ano) {
    return ano%4 == 0 && ano%100 != 0 || ano%400 == 0;
  }

  // Crie métodos para obter o dia, mes e ano da data.
  //...

  /** Dimensões dos meses num ano comum. */
  private static final
  int[] diasMesComum = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  
  private static final
  String[] mesext = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
  
  /** Devolve o número de dias do mês dado. */
  public static int diasDoMes(int mes, int ano) {
	  assert mes > 0 && mes <= 12 : "Mês inválido";
	  int result = 0;
	  if (mes == 2 && bissexto(ano)) {
		  result = 29;;
	  }
	  else {
		  result = diasMesComum[mes-1];
	  }
	  assert result > 0 && result<=31;
	  return result;
  }

  /** Devolve o mes da data por extenso. */
  public String mesExtenso() {
	  return mesext[(this.mes()-1)];
  }

  /** Devolve esta data por extenso. */
  public String extenso() {
    return this.dia() + " de " + this.mesExtenso() + " de " + this.ano();
  }

  /** Indica se um terno (dia, mes, ano) forma uma data válida. */
  public static boolean dataValida(int dia, int mes, int ano) {
	  
	  if (mes < 1 || mes >12) {
		  return false;
	  }
	  else if(mes == 2 && bissexto(ano)) {
		  if (dia>=1 && dia <=29)
			  return true;
	  }
	  else {
		  if (dia >= 1 && dia <= diasMesComum[mes-1])
			  return true;
	  }
	  
	  return false;
  }

  public void seguinte() {
	  
	  int novodia = dia +1;
	  int novomes = mes;
	  
	  
	  if(dia == diasMesComum[mes-1]) {
		  novodia = 1;
		  novomes = mes+1;
	  }
	 
	  if(mes == 2 && bissexto(ano) && dia==29) {
			  novodia = 1;
	  		  novomes = 3;
	  }
	  
	  if(dia == 31 && mes == 12) {
		  novodia = 1;
		  novomes = 1;
		  ano = ano+1;
	  }
	  
	  
	  dia = novodia;
	  mes = novomes;  
	  
	  assert dataValida(dia,mes,ano);
	
  }
  
public Data dataseguinte() {
	  
	  int novodia = dia +1;
	  int novomes = mes;
	  int novoano = ano;
	  
	  
	  if(dia == diasMesComum[mes-1]) {
		  novodia = 1;
		  novomes = mes+1;
	  }
	 
	  if(mes == 2 && bissexto(ano) && dia==29) {
			  novodia = 1;
	  		  novomes = 3;
	  }
	  
	  if(dia == 31 && mes == 12) {
		  novodia = 1;
		  novomes = 1;
		  novoano = ano+1;
	  }
	  
	  return new Data(novodia,novomes,novoano);
  }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ano;
	result = prime * result + dia;
	result = prime * result + mes;
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Data other = (Data) obj;
	if (ano != other.ano)
		return false;
	if (dia != other.dia)
		return false;
	if (mes != other.mes)
		return false;
	return true;
}

public int compareTo(Data d) {
	if(this.equals(d)) return 0;
	
	if(this.ano()>d.ano()) 
		return 1;
	else if(this.ano()==d.ano() && this.mes()>d.mes()) 
		return 1;
	else if(this.ano()==d.ano() && this.mes()==d.mes() && this.dia() > d.dia()) 
		return 1;
	else return -1;
}


}

