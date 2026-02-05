public class App {
    public static void main(String[] args) throws Exception {


            System.out.println("PRINT + SIZE");
            DoublyLinkedList list1 = new DoublyLinkedList();
            list1.add(new Node('A'));
            list1.add(new Node('B'));
            list1.add(new Node('C'));
            list1.add(new Node('D'));
            list1.add(new Node('E'));
        
            System.out.print("Forward:  ");
            list1.print(true);
        
            System.out.print("Backward: ");
            list1.print(false);
        
            System.out.println("Size: " + list1.size());
            System.out.println();
        

           // System.out.println("SLICE");
           // DoublyLinkedList sliceList = new DoublyLinkedList();
           // sliceList.add(new Node('A'));
           // sliceList.add(new Node('B'));
           // sliceList.add(new Node('C'));
           // sliceList.add(new Node('D'));
           // sliceList.add(new Node('E'));
        //
           // System.out.println("ABCDE slice(0,3) -> " + sliceList.slice(0, 3)); // ABC
           // System.out.println("ABCDE slice(2,3) -> " + sliceList.slice(2, 3)); // C
           // System.out.println("ABCDE slice(1,1) -> " + sliceList.slice(1, 1)); // ""
           // System.out.println("ABCDE slice(3,1) -> " + sliceList.slice(3, 1)); // DC
           // System.out.println();
        

            System.out.println("REMOVE REPETITIONS");
            DoublyLinkedList repList = new DoublyLinkedList();
            String s = "ABBCCCDEEEE";
            for (int i = 0; i < s.length(); i++) {
                repList.add(new Node(s.charAt(i)));
            }
        
            System.out.print("Before: ");
            repList.print(true);
        
            repList.removeRepetitions();
        
            System.out.print("After:  ");
            repList.print(true);
            System.out.println();
        
        

            System.out.println("MIRROR");
        
            DoublyLinkedList m1 = new DoublyLinkedList();
            for (char c : "ABCD".toCharArray()) m1.add(new Node(c));
            System.out.print("ABCD mirror(3) -> ");
            m1.mirror(3);
            m1.print(true); 
        
            DoublyLinkedList m2 = new DoublyLinkedList();
            for (char c : "ABCD".toCharArray()) m2.add(new Node(c));
            System.out.print("ABCD mirror(1) -> ");
            m2.mirror(1);
            m2.print(true);

            DoublyLinkedList m3 = new DoublyLinkedList();
            for (char c : "ABCD".toCharArray()) m3.add(new Node(c));
            System.out.print("ABCD mirror(0) -> ");
            m3.mirror(0);
            m3.print(true); 
        
            System.out.println();
        

            System.out.println("EXTRACT");
        
            DoublyLinkedList e1 = new DoublyLinkedList();
            for (char c : "ABCDEDCBA".toCharArray()) e1.add(new Node(c));
        
            System.out.print("Before: ");
            e1.print(true);
        
            e1.extract('C');
        
            System.out.print("After extract('C'): ");
            e1.print(true); 
        
            System.out.println();
        
            DoublyLinkedList e2 = new DoublyLinkedList();
            for (char c : "ABCBA".toCharArray()) e2.add(new Node(c));
        
            System.out.print("Before: ");
            e2.print(true);
        
            e2.extract('C');
        
            System.out.print("After extract('C'): ");
            e2.print(true); 
        
            System.out.println();
        
        
            System.out.println("ATTACH");
        
            DoublyLinkedList base = new DoublyLinkedList();
            for (char c : "CDE".toCharArray()) base.add(new Node(c));
        
            DoublyLinkedList other = new DoublyLinkedList();
            for (char c : "AB".toCharArray()) other.add(new Node(c));
        
            System.out.print("Base list:  ");
            base.print(true);
        
            System.out.print("Other list: ");
            other.print(true);
        
            base.attach(other);
        
            System.out.print("After base.attach(other): ");
            base.print(true);
        
            System.out.print("Backward check: ");
            base.print(false);
        
            System.out.println();
        }
    
}
