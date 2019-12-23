public class Sort {

    // NODE. A node in a linear singly linked list of INTs.
    private static class Node {

        private int number; // The INT in the node, duh.
        private Node next;    // The NODE that follows this one, or NULL.

        // Constructor. Initialize a new NODE with NUMBER and NEXT.
        private Node(int number, Node next) {
            this.number = number;
            this.next = next;
        }
    }

    // MAKE NODES. Return a list of NODEs that contains INTs from NUMBERS in order
// of their appearance.
    private static Node makeNodes(int... numbers) {
        if (numbers.length > 0) {
            Node first = new Node(numbers[0], null);
            Node last = first;
            for (int index = 1; index < numbers.length; index += 1) {
                last.next = new Node(numbers[index], null);
                last = last.next;
            }
            return first;
        } else {
            return null;
        }
    }

    private static void writeNodes(Node nodes) {
        System.out.print('[');
        if (nodes != null) {
            System.out.print(nodes.number);
            nodes = nodes.next;
            while (nodes != null) {
                System.out.print(", ");
                System.out.print(nodes.number);
                nodes = nodes.next;
            }
        }
        System.out.println(']');
    }

    private static Node sortNodes(Node unsorted) {
        boolean isEven = false;
        Node sorted,left,right,newLeft,newRight,temp1,temp2;
        left = null;
        right = null;
        temp2 = null;
        if (unsorted == null || unsorted.next == null) {
            return unsorted;
        }
        while (unsorted != null) {
            if (isEven) {
                temp1 = unsorted;
                unsorted = unsorted.next;
                if(right == null){
                    right = temp1;
                    right.next = null;
                }
                else{
                    temp2 = right;
                    right = temp1;
                    right.next = temp2;
                    temp2 = null;
                }
                isEven = false;
            } else {
                temp1 = unsorted;
                unsorted = unsorted.next;
                if(left == null){
                    left = temp1;
                    left.next = null;
                }
                else{
                    temp2 = left;
                    left = temp1;
                    left.next = temp2;
                    temp2 = null;
                }
                isEven = true;
            }
        }
        newRight = sortNodes(right);
        newLeft = sortNodes(left);
        temp1 = temp2;
        if (newLeft.number > newRight.number) {
            temp1 = newRight;
            sorted = newRight;
            newRight = newRight.next;
            temp1.next = null;
        } else {
            temp1 = newLeft;
            sorted = newLeft;
            newLeft = newLeft.next;
            temp1.next = null;
        }
        while((newLeft != null) && (newRight != null)){
            if(newLeft.number > newRight.number){
                temp1.next = newRight;
                temp1 = temp1.next;
                newRight = newRight.next;
                temp1.next = null;
            }
            else{
                temp1.next = newLeft;
                temp1 = temp1.next;
                newLeft = newLeft.next;
                temp1.next = null;
            }
        }
        if((newRight != null) && (newLeft == null)){
             temp1.next = newRight;
        }
        else{
            temp1.next = newLeft;
        }
        return sorted;
    }

    // MAIN. Run some examples. The comments show what must be printed.
    public static void main(String[] args) {
        writeNodes(sortNodes(makeNodes()));      // []
        writeNodes(sortNodes(makeNodes(1)));     // [1]
        writeNodes(sortNodes(makeNodes(1, 2))); // [1, 2]
        writeNodes(sortNodes(makeNodes(2, 1))); // [1, 2]

        writeNodes(sortNodes(makeNodes(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        // [1, 2, 3, 4, 5, 6, 7, 8, 9]

        writeNodes(sortNodes(makeNodes(9, 8, 7, 6, 5, 4, 3, 2, 1)));
        // [1, 2, 3, 4, 5, 6, 7, 8, 9]

        writeNodes(sortNodes(makeNodes(3, 1, 4, 5, 9, 2, 6, 8, 7)));
        // [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
// OUTPUTS
//[]
//[1]
//[1,2]
//[1,2]
//[1, 2, 3, 4, 5, 6, 7, 8, 9]
//[1, 2, 3, 4, 5, 6, 7, 8, 9]
//[1, 2, 3, 4, 5, 6, 7, 8, 9]