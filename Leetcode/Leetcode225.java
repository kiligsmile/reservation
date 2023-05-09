class MyStack {

    Queue<Integer> queue=new LinkedList<>();
    private int size=0;
    public MyStack() {

    }
    
    public void push(int x) {
        queue.offer(x);
        for(int i=0;i<size;i++){
            queue.offer(queue.poll());
        }
        size++;
    }
    
    public int pop() {
        size--;
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}