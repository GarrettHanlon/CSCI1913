public class AssociationList<Key, Value> {
    private class Node{
        private Key key;
        private Value value;
        private Node next;
        private Node head;
        private Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }
    public Node head;
    public Node temp;
    public Node left;
    public Node right;


    public AssociationList(){
        head = new Node(null,null,null);
    }

    public void delete(Key key){








        if(isIn(key)){
            left = head.next;
            right=left.next;
            while (right != null) {
                if(isEqual(right.key,key)){
                    left.next = right.next;
                    break;

                }
                else{
                    left = right;
                    right = right.next;
                }
            }
        }
    }

    public Value get(Key key){



        if(isIn(key)){
            temp = head.next;
            while(temp != null){
                if(isEqual(temp.key,key)){
                    break;
                }
                else{
                    temp = temp.next;
                }
            }
        }
        else{
            throw new IllegalArgumentException("Key not in list");

        }
        return temp.value;
    }
    private boolean isEqual(Key leftkey, Key rightkey){
        if(leftkey == null || rightkey == null){
            return leftkey == rightkey;
        }
        else{
            return leftkey.equals(rightkey);
        }
    }

    public boolean isIn(Key key){
        temp = head.next;
        while(temp != null){
            if(isEqual(temp.key, key) ){
                return true;
            }
            else{
                temp = temp.next;
            }
        }
        return false;
    }

    public void put(Key key, Value value){
        temp = head.next;
        if(isIn(key)){
            while(temp != null){
                if(isEqual(temp.key, key) ){
                    temp.value = value;
                    break;
                }
                else{
                    temp = temp.next;
                }
            }
        }
        else{
           Node newNode = new Node(key,value,head.next);
           head.next = newNode;
        }
    }

}
class Hogwarts
        {

//  MAIN. Make an instance of ASSOCIATION LIST and test it.

public static void main(String[] args)
        {
        AssociationList<String,String> list = new AssociationList<String,String>();

        System.out.println(list.isIn(null));         //  false         2 points.

        try
        {
        System.out.println(list.get(null));
        }
        catch (IllegalArgumentException ignore)
        {
        System.out.println("No null");             //  No null       2 points.
        }

        list.put(null,        "Wormtail");
        list.put("Ron",       "Lavender");
        list.put("Voldemort", null);
        list.put("Dean",      "Ginny");

        System.out.println(list.isIn("Dean"));       //  true          2 points.
        System.out.println(list.isIn("Ginny"));      //  false         2 points.
        System.out.println(list.isIn("Ron"));        //  true          2 points.
        System.out.println(list.isIn("Voldemort"));  //  true          2 points.
        System.out.println(list.isIn(null));         //  true          2 points.
        System.out.println(list.isIn("Joanne"));     //  false         2 points.

        System.out.println(list.get("Ron"));         //  Lavender      2 points.
        System.out.println(list.get("Dean"));        //  Ginny         2 points.
        System.out.println(list.get("Voldemort"));   //  null          2 points.
        System.out.println(list.get(null));          //  Wormtail      2 points.

        try
        {
        System.out.println(list.get("Joanne"));
        }
        catch (IllegalArgumentException ignore)
        {
        System.out.println("No Joanne");           //  No Joanne     2 points.
        }

        list.delete(null);

        System.out.println(list.isIn(null));         //  false         2 points.

        list.put(null,    null);
        list.put("Harry", "Ginny");
        list.put("Ron",   "Hermione");

        System.out.println(list.isIn(null));         //  true          2 points.
        System.out.println(list.get(null));          //  null          2 points.
        System.out.println(list.get("Harry"));       //  Ginny         2 points.
        System.out.println(list.get("Dean"));        //  Ginny         2 points.
        System.out.println(list.get("Ron"));         //  Hermione      2 points.

        list.delete("Dean");

        try
        {
        System.out.println(list.get("Dean"));
        }
        catch (IllegalArgumentException ignore)
        {
        System.out.println("No Dean");             //  No Dean       2 points.
        }
        }
        }