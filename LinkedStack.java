public class LinkedStack<T> implements Stack<T> {

  private class Elem<E>{

    private E info;
    private Elem<E> next;

    private Elem(E info, Elem<E> next){
      this.info = info;
      this.next = next;
    }
  }

  private Elem<T> top;

  public int size(){
    Elem<T> tmp = top;
    int count = 0;
    while(tmp != null){
      count = count + 1;
      tmp = tmp.next;
    }
    return count;
  }
  
  public boolean swap(){
    boolean something = true;
    if(top == null || top.next == null){
      something = false;
    }

    Elem<T> one = top;
    Elem<T> two = top.next;
    one.next = two.next;
    two.next = one;
    top = two;

    return something;

  }
}
