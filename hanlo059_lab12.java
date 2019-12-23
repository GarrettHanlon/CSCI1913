class PriorityQueue<Base>
{
    private class Node
    {
        private Base object;
        private int  rank;
        private Node left;
        private Node right;

        private Node(Base object, int rank)
        {
            this.object = object;
            this.rank = rank;
            left = null;
            right = null;
        }

    }
    private Node head;
    public PriorityQueue(){
        root = new Node(null, Integer.MAX_VALUE);
        head = root;
    }
    public Base dequeue(){
        Node above = head;
        Node below = head.left;
        if(isEmpty()){
            throw new IllegalStateException("Empty");
        }
        else{
            while(below.left != null){
                above = below;
                below = below.left;
            }
            above.left = below.right;
            return below.object;
        }
    }
    public void enqueue(Base object, int rank){
        Node n = head;
        boolean check = true;
        if(rank < 0 ){
            throw new IllegalArgumentException("rank negative");
        }
        else{
            while(check){
                if(rank >= n.rank){
                    if(n.right == null){
                        n.right = new Node(object,rank);
                        check = false;

                    }
                    else{
                        n = n.right;
                    }
                }
                else if(rank < n.rank){
                    if(n.left == null){
                        n.left = new Node(object,rank);
                        check = false;
                        
                    }
                    else{
                        n= n.left;
                    }
                }
            }
        }
    }
    public boolean isEmpty(){
        return head.left == null;
    }
    private Node root;  //  Root node of the BST.
 

}