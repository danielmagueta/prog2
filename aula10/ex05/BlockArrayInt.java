// Altere esta classe para implementar um tipo de dados abstrato que funciona
// como um array, com métodos de put e get.
// A implementação fornecida cria um único array, mas queremos substituí-lo
// por uma lista de blocos (arrays de tamanho blocksize), que poderá crescer
// juntando progressivamente mais blocos à lista.
package aula10.ex05;
import aula10.p2utils.*;
public class BlockArrayInt
{
		
  private LinkedList<int[]> lista;
  private int numBlocks;
  private int blockSize;
  
  public BlockArrayInt(int blockSize, int numBlocks) {
    assert blockSize > 0;
    assert numBlocks > 0;
    this.blockSize = blockSize;
    this.numBlocks = numBlocks;
    int[] a = new int[blockSize];
    lista = new LinkedList<int[]>();
    for(int i = 0; i < numBlocks; i++) {
    	lista.addLast(a);
    }
  }

  public int get(int index) {
    assert validIndex(index);
    int whichblock = index/blockSize;
    int pos = index - (blockSize*whichblock);
    int[] aa = lista.get(whichblock);
    return aa[pos];
  }

  public void put(int elem, int index) {
    assert validIndex(index);
    int whichblock = index/blockSize;
    int pos = index - (blockSize*whichblock);
    int[] aa = lista.get(whichblock);
    aa[pos] = elem;
  }

  public void incrementNumberOfBlocks() {
    numBlocks++;
    int[] b = new int[blockSize];
    lista.addLast(b);
  }

  public int size() {
    return blockSize*numBlocks;
  }

  public int numberOfBlocks() {
    return numBlocks;
  }

  public int blockSize() {
    return blockSize;
  }

  public boolean validIndex(int index) {
    return index >= 0 && index < size();
  }

}

