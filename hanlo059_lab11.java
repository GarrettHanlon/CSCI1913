 class Deque<Base> {
    private class Node{
        private Base object;
        private Node left, right;
        private Node(Base object, Node left, Node right){
            this.object = object;
            this.left = left;
            this.right = right;
        }
    }
    private Node head;
    public Deque(){
        head = new Node(null,null,null);
        head.right = head.left = head;


    }
    public void enqueueFront(Base object){
        Node temp = new Node(object, head, head.right);
        head.right.left = temp;
        head.right = temp;
    }
     public void enqueueRear(Base object){
         Node temp = new Node(object, head.left, head);
         head.left.right = temp;
         head.left = temp;
     }
     public Base dequeueFront(){
        if(isEmpty()){
            throw new IllegalStateException("empty");
        }
        else{
            Node temp = head.right;
            temp.right.left = head;
            head.right = temp.right;
            return temp.object;

        }
     }
     public Base dequeueRear(){
        if(isEmpty()){
            throw new IllegalStateException("empty");
        }
        else{
            Node temp = head.left;
            temp.left.right = head;
            head.left = temp.left;
            return temp.object;
        }
     }
     public boolean isEmpty(){
         if(head == head.right && head.left == head){
             return true;
         }
         else{
             return false;
         }
     }
}
