package GTA.E08;

import java.math.BigInteger;

/**
 * Tipo de dados representando uma fracção.
 * Nesta versão pretende-se garantir um invariante (interno) mais forte:
 * as frações armazenadas devem ter sempre denominador positivo.
 * Isto permite simplificar alguns métodos.
 *
 * AVISO: Vários métodos podem dar erros devidos a overflow.
 * (Não deve haver problemas com numeradores e denominadores até 46430.)
 *
 * @author João Manuel Rodrigues
 * 2007--2018
 */

public class Fraction implements Comparable<Fraction>
{
  private int num;
  private int den;
  public static final Fraction ZERO = new Fraction(0,1);
  public static final Fraction ONE = new Fraction(1,1);

  /** Cria uma nova fracção a partir de um par (numerador, denominador).
   *  @param num numerador da nova fracção.
   *  @param den denominador da nova fracção.
   *  <b>Exige (pré-condição):</b> den != 0.
   */
  public Fraction(int num, int den) {
    assert den != 0; // check precondition
    if (den<0) {
    	den = den*-1;
    	num = num *-1;
    }
    this.num = num;
    this.den = den;
    assert invariant(); // check object invariant
  }

  /* Testa o invariante do objeto.
   * Ou seja, a propriedade que define a validade de uma fração.
   * É para testar em asserções nos métodos.
   */
  public boolean invariant() {
    return den > 0 ; // O denominador não pode ser nulo!
  }

  /** Converte uma string numa fracção.
   *  @param str String no formato {@code "inteiro/inteiro"}
   *             representando uma fracção válida.
   *  @return fracção correspondente a {@code str}.
   */
  public static Fraction parseFraction(String str) {
    String[] p = str.split("/", 2);  // divide a string em até 2 partes
    int n = Integer.parseInt(p[0]);  // extrai numerador
    int d = (p.length==2)? Integer.parseInt(p[1]) : 1;
        // se tem 2 partes, extrai denominador, senão fica d=1
    return new Fraction(n, d);
  }

  /** Converte a fracção numa string.
   *  @return string com a representação desta fracção.
   */
  public String toString() {
    // Com um invariante mais forte, podemos simplificar este método!
    String s = num + "/" + den;
    return s;
  }

  /** Devolve o numerador da fracção.
   *  @return numerador desta fração.
   */
  public int num() { return num; }

  /** Devolve o denominador da fracção.
   *  @return denominador desta fração.
   */
  public int den() { return den; }

  /** Multiplica esta fracção por outra (this * b).
   *  @param b multiplicando.
   *  @return fracção produto de this * b.
   */
  public Fraction multiply(Fraction b) {
    int n = num*b.num;
    int d = den*b.den;
    assert n/b.num == num;
    assert d/b.den == den;
    Fraction p = new Fraction(n, d); // product
    assert p.invariant();
    return p.reduceFraction();
  }

  /** Adiciona esta fracção com outra (this + b).
   *  @param b fracção a adicionar a esta.
   *  @return fracção soma de this + b.
   */
  public Fraction add(Fraction b) {
    int n = num*b.den + den*b.num;
    int d = den*b.den;
    assert n - den*b.num == num*b.den;
    assert d/b.den == den;
    Fraction s = new Fraction(n, d); // sum
    assert s.invariant();
    return s.reduceFraction();
  }

  public Fraction divide(Fraction b) {
	  assert b.num != 0;
	  int n = num*b.den;
	  int d = den*b.num;
	  assert n/b.den == num;
	  assert d/b.num == den;
	  Fraction p = new Fraction(n, d); // product
	  assert p.invariant();
	  return p.reduceFraction();
  }

  public Fraction subtract(Fraction b) {
	  int n = num*b.den - den*b.num;
	  int d = den*b.den;
	  assert n + den*b.num == num*b.den;
	  assert d/b.den == den;
	  Fraction s = new Fraction(n, d); // sum
	  assert s.invariant();
	  return s.reduceFraction();
  }

  public boolean equals(Fraction b) {
    Fraction test1 = this.reduceFraction();
    Fraction test2 = b.reduceFraction();
	if(test1.num == test2.num && test1.den == test2.den) return true;
    return false;
  }
  
  public Fraction reduceFraction() {
	int cgd = 0;
	int n_num = num;
	int n_den = den;
	while(cgd !=1) {
		  cgd = cgd(n_num, n_den);
		  n_num = n_num/cgd;
		  n_den = n_den/cgd;
	}
	return new Fraction(n_num,n_den);
  }
  
  public int[] reduce(int num, int den) {
		int array[] = new int[2];
	  	int cgd = 0;
		int n_num = num;
		int n_den = den;
		while(cgd !=1) {
			  cgd = cgd(n_num, n_den);
			  n_num = n_num/cgd;
			  n_den = n_den/cgd;
		}
		array[0] = n_num;
		array[1] = n_den;
		return array;
	  }
  
  public boolean simplified() {
		int cgd = cgd(num,den);
		if(cgd == 1) return true;
		return false;
	  }
  
  public int cgd(int a, int b) {
	  BigInteger b1 = BigInteger.valueOf(a);
	  BigInteger b2 = BigInteger.valueOf(b);
	  BigInteger gcd = b1.gcd(b2);
	  return gcd.intValue();
  }

  public int compareTo(Fraction b) {
    int this_num = this.num * b.den;
    int b_num = b.num * this.den;
    if(this_num > b_num) return 1;
    else if(this_num < b_num) return -1;
    else {return 0;}
    
  }

}
