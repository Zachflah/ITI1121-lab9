public class Q3 interface Queue {
  public static <E> void swap(Stack<E> xs, Stack <E> ys){

    Stack<E> tmp = new Stack<E

    while(!xs.isEmpty()){
      tmp.push(xs.pop());
    }
    while(!ys.isEmpty()){
      xs.push(ys.pop());
    }
    while(!tmp.isEmpty()){
      ys.push(tmp.pop());
    }
    while(!xs.isEmpty()){
      tmp.push(xs.pop());
    }
    xs = tmp;

  }
}
