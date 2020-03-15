public class Q1 implements Stack{

  public boolean isSkipped(Stack s1,Stack s2){

    Stack tmp1 = new Stack();
    Stack tmp2 = new Stack();
    Stack tmp3 = new Stack();
    boolean something = true;

    while(!s1.isEmpty()){
      tmp1.push(s1.pop());
      tmp2.push(s2.pop());
      if(s1.peek()%2 == 0){
        tmp3.push(s1.pop());
      }
      if(tmp1.peek() != tmp2.peek()){
        something = false;
      }
    }
    while(!tmp1.isEmpty()){
      s1.push(tmp1.pop());
      s2.push(tmp2.pop());
      if(!tmp3.isEmpty()){
        s1.push(tmp3.pop());
      }
    }
    return something;
  }
}
