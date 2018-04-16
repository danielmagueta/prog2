package aula02.pt.ua.prog2;

public class Contacto {
  private String nome;
  private String telefone;
  private String eMail;
  
  public Contacto(String nome, String telefone, String eMail) {
	  this.nome = nome;
	  this.telefone = telefone;
	  this.eMail = eMail;
  }
  public Contacto(String nome, String telefone) {
	  this.nome = nome;
	  this.telefone = telefone;
  }

  public String nome() {
	return nome.toUpperCase();
  }
  public String telefone() {
	return telefone;
  }
  public String eMail() {
	return eMail;
  }
  
  

}
