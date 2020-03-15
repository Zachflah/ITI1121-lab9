public class CircularQueue<E>{

  public static final int DEFAUKT_CAPACITY = 100;
  private final int MAX_QUEUE_SIZE;
  private E[] elems;
  private int front,rear;

  public CircularQueue(){
    this(DEFAUKT_CAPACITY);
  }

  public CircularQueue(int capacity){
    if(capacity < 0){
      throw new IllegalArgumentException(Integer.toString(capacity));
    }
    MAX_QUEUE_SIZE = capacity;
    elems = new E[MAX_QUEUE_SIZE];
    front = 0;
    rear = -1;
  }
  public boolean isEmpty(){
    return(rear == -1);
  }
  public boolean isFull(){
    return !isEmpty() && nextIndex(rear) == front;
  }
  private int nextIndex(int index){
    return (index +1)% MAX_QUEUE_SIZE;
  }
  public void dump(){
    System.out.println("MAX_QUEUE_SIZE = " + MAX_QUEUE_SIZE);
    System.out.println("front = " + front);
    System.out.println("rear = " + rear);
    for(int i = 0; i < elems.length; i++){
      System.out.print("elems[" + i +"] = ");
      if(elems[i] == null){
        System.out.println("null");
      }
      else{
        System.out.println(elems[i]);
      }
    }
    System.out.println();
  }
  public void enqueue(E o){
    if (o == null){
      throw new IllegalArgumentException("null");
    }
    if(isFull()){
      throw new QueueOverflowException();
    }
    rear = nextIndex(rear);
    elems[rear] = o;
  }
  public E dequeue(){
    if(isEmpty()){
      throw new EmptyQueueException();
    }
    E result = elems[front];
    elems[front] = null;
    if(front == rear){
      front = 0;
      rear = -1;
    }
    else{
      front = nextIndex(front);
    }
    return result;
  }

  public void main(String[] args){

    CircularQueue<Integer> q;
    q = new CircularQueue<Integer>(4);
    int i = 0;
    while(!q.isFull()){
      i++;
      q.enqueue(new Integer(i));
    }
    if(!q.isEmpty()){
      q.dequeue();
    }
    if(!q.isEmpty()){
      q.dequeue();
    }
    while(!q.isFull()){
      i++;
      q.enqueue(new Integer(i));
    }
    q.dump();

    while(!q.isEmpty()){
      q.dequeue();
    }
    q.dump();

  }
}
