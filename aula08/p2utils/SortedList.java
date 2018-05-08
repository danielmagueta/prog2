package aula08.p2utils;
public class SortedList<E extends Comparable<E>>
{
  // private attributes
  private Node<E> first = null;
  private int size = 0;

  public SortedList() { }

  /**
   * @return Number of elements in the list
   */
  public int size() { return size; }

  /** Checks if the list is empty.
   * @return  {@code true} if list empty, otherwise {@code false}.
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * @return  First element in the list
   */
  public E first() {
    assert !isEmpty(): "empty!";
      return first.elem;
  }

  /** Inserts a new element in the list.
   * @param e the element to be inserted
   */
  public void insert(E e) {
    first = insert(first,e);
    size++;
  }
  private Node<E> insert(Node<E> n,E e) {
    if (n==null || e.compareTo(n.elem)==-1)
      return new Node<E>(e,n);
    n.next = insert(n.next,e);
    return n;
  }

  /** Removes the first element in the list.
   */
  public void removeFirst() {
    assert !isEmpty(): "empty!";
    first = first.next;
    size--;
  }

  /** Checks if the list is sorted.
   * @return {@code true} if sorted, {@code false} otherwise
   */
  public boolean isSorted() { 
    if (size < 2)
      return true;
    return isSorted(first,first.next); 
  }
  private boolean isSorted(Node<E> prev,Node<E> n) {
    if (n == null) return true;
    if (n.elem.compareTo(prev.elem)==-1) return false;
    return isSorted(n,n.next);
  }
  
  public E get(int i) {
	  return get(first, i);
  }
  
  private E get(Node<E> n, int i) {
	  for(int j = 0; j< i; j++) {
		  n = n.next;
	  }
	  return n.elem;
  }
  
  //copy
  
  public SortedList<E> copy() {
	  SortedList<E> nova = new SortedList<E>();
	  Node<E> n = first;
	  while(n != null) {
		  nova.insert(n.elem);
		  n = n.next;
	  }
	  return nova;
  }
  
  //contains
  public boolean contains(E e) {
	  return contains(first, e);
  }
  
  private boolean contains(Node<E> n, E e) {
	  if(n == null) return false;
	  if(n.elem.equals(e)) return true;
	  return contains(n.next, e);
  }
  
  
  //toString
  public String toString() {
	  String s = "[";
	  Node<E> n = first;
	  for (int i = 0; i < size; i++) {
		  s += n.elem;
		  if(n.next!=null) {
			  s += ", ";
		  }
		  n = n.next;
	  }
	  s += "]";
	  return s;
  }
  
  //merge
  public SortedList<E> merge(SortedList<E> sl) {
	  SortedList<E> nova = this.copy();
	  return merge(sl.first, nova);
  }
  
  public SortedList<E> merge(Node<E> n, SortedList<E> k) {
	  k.insert(n.elem);
	  if(n.next!=null) {
		  merge(n.next,k);
	  }
	  return k;
  }
  	

}
