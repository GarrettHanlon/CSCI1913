ublic class RunnyStack<Base> {

    private class Run {
       private Base base;
       private Run next;
       private int length;

       private Run(Base base, Run next, int lenght){
           this.base = base;
           this.next = next;
           this.length = length;
        }

    }
    int depth_sum;
    int runSum;
    private Run top;
    public RunnyStack(){
        top = new Run(null, null, 0);
        depth_sum = 0;
        runSum = 0;
    }

    public int depth(){
        return depth_sum;
    }
    public boolean isEmpty(){
        return top.base == null;
    }
    public Base peek(){
        if(isEmpty()){
            throw new IllegalStateException("Empty Stack");
        }
        else{
            return top.base;
        }
    }
    public void pop(){
        if(isEmpty()){
            throw new IllegalStateException("Empty Stack");
        }
        else {
            if(top.length > 1){
                top.length--;
                depth_sum--;
            }
            else{
                top = top.next;
                depth_sum --;
                runSum--;

            }
        }
    }
    public void push(Base base){
        if(isEmpty()){
            top = new Run(base, top, top.length);
            depth_sum++;
            runSum++;
        }
        else{
            if(isEqual(base,top.base)){
                top.length++;
                depth_sum++;
            }
            else{
                top = new Run(base, top, top.length);
                top.length++;
                depth_sum++;
                runSum++;
            }
        }
    }
    private boolean isEqual(Base x, Base y){
        if(x == null || y == null){
            return x == y;
        }
        return x.equals(y);
    }

    public int runs(){
        return runSum;
    }
}