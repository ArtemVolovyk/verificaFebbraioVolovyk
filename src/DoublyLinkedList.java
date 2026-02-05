

public class DoublyLinkedList {
    
    private Node head, tail;

    public DoublyLinkedList() {
        this.head = this.tail = null;
    }

    /**
     * Adds a node at the end of the list
     * @param newNode new node to be added
     */
    public void add(Node newNode) {
        if (head == null && tail == null) {
            head = tail = newNode;
        }
        else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    // wrapper
    private Node getRec(Node cursor, int index) {

        if (index == 0)
            return cursor;

        return getRec(cursor.getNext(), index-1);
    }

    /**
     * Gets the element in the specified position
     * @param index position to read
     * @return the element identified by the index
     * @throws IndexOutOfBoundsException
     */
    public Node get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Invalid index");

        return getRec(head, index);
    }

    // ------------ INSERT YOUR CODE HERE ----------------

    public void print(boolean forward) {
        if(forward){
            printForward(head);
        } else {
            printBackward(tail);
        }
        System.out.println();
    }

    private void printForward(Node cursor){
        if (cursor == null) return;
        System.out.print(cursor.getLetter());
        printForward(cursor.getNext());
    }

    private void printBackward(Node cursor){
        if (cursor == null) return;
        System.out.print(cursor.getLetter());
        printBackward(cursor.getNext());
    }

    public int size() {
        int count = 0;
        Node cursor = head;
        while (cursor != null){
            count++;
            cursor = cursor.getNext();
        }
        return count;
    }


    // if cuurent empty then becomes otherList 
    public void attach(DoublyLinkedList otherList){

        if ( otherList == null || otherList.head == null) return;

        if (this.head == null){
            this.head = otherList.head;
            this.tail = otherList.tail;

            otherList.head = null;
            otherList.tail = null;
            return;
        }

        otherList.tail.setNext(this.head);
        this.head.setPrev(otherList.tail);

        this.head = otherList.head;

        otherList.head = null;
        otherList.tail = null;


        //if ( otherList == null || otherList.head == null) return;
//
        //if (this.head == null){
        //    this.head = otherList.head;
        //    this.tail = otherList.tail;
//
        //    return;
        //}
//
        //otherList.tail.setNext(this.head);
        //this.head.setPrev(otherList.tail);
//
        //this.head = otherList.head;
    }

    public String slice (int start, int end){
        int n = size();

        if (start < 0) start = 0;
        if (start < n) start = n;
        if (end < 0) end = 0;
        if (end > n) end = n;

        //if (start < 0 || start >= n || end < 0 || >= n){
          //  throw new IndexOutOfBoundsException("invalid index");
        //}

        if ( start== end ) return "";

        StringBuilder sb = new StringBuilder();

        if (start < end){
            Node cur = get(start);
            int i = start;

            while ( cur != null && i < end){
                sb.append(cur.getLetter());
                cur = cur.getNext();
                i++;
            }
        } else{
            Node cur = get(start);
            int i = start;

            while ( cur != null && i > end){
                sb.append(cur.getLetter());
                cur = cur.getPrev();
                i--;
            }
        }
        return sb.toString();
    }

    public void removeRepetitions(){
        if ( head == null ) return;

        Node cur = head;

        while ( cur != null && cur.getNext() != null){
            
            if(cur.getLetter() == cur.getNext().getLetter()){
                Node remove = cur.getNext();
                Node removed = remove.getNext();

                cur.setNext(removed);

                if ( removed != null ){
                    removed.setPrev(cur);
                } else {
                    tail = cur; // remove tail
                }
            } else {
                cur = cur.getNext();
            }
        }
    }

    public void mirror(int index){
        if ( head == null ) return;
        if ( index < 0 || index >= size()) return;

        Node pivot = get(index);

        Node afterPivot = pivot.getNext();
        pivot.setNext(null);
        tail = pivot;

        if ( afterPivot != null ){
            afterPivot.setPrev(null);
        }

        Node cur = pivot.getPrev();
        while (cur != null ) {
            add(new Node(cur.getLetter()));
            cur = cur.getPrev();
        }
    }

    public void extract(char c){
        if ( head == null ) return;

        Node first = null;
        Node last = null;

        Node cur = head;
        while ( cur != null){
            if ( cur.getLetter() == c){
                if ( first == null ) first = cur;
                last = cur;
            }
            cur = cur.getNext();
        }

        if ( first == null || first == last ) return;

        // left side
        Node left = first.getPrev();
        if (left != null){
            left.setNext(null);
        }
        first.setPrev(null);

        // right side 
        Node right = first.getNext();
        if (right != null){
            right.setPrev(null);
        }
        first.setNext(null);

        head = first;
        tail = last;
    }



}
