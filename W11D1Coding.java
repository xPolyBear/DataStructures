public class W11D1Coding {
    public static void main(String[] args) {
        System.out.println("");
        W11D1Coding list = new W11D1Coding();
        

        System.out.println("Test 1 = Append: 10, 3, 7, 2, 8");
        list.Append(10);
        list.Append(3);
        list.Append(7);
        list.Append(2);
        list.Append(8);
        list.Print();
        System.out.println("");

        System.out.println("Test 2 = Prepend: 6, 4");
        list.Prepend(6);
        list.Prepend(4);
        list.Print();
        System.out.println("");

        System.out.println("Test 3 = InsertAfter: Insert 5 after 7");
        W11D1Coding.Node node7 = list.Search(7);
        W11D1Coding.Node node5 = new W11D1Coding.Node(5);
        if (node7 != null) {
            list.InsertAfter(node7, node5);
        }
        list.Print();
        System.out.println("");

        System.out.println("Test 4 = InsertBefore: Insert 9 before 10");
        W11D1Coding.Node node10 = list.Search(10);
        W11D1Coding.Node node9 = new W11D1Coding.Node(9);
        if (node10 != null) {
        list.InsertBefore(node10, node9);
        }
        list.Print();
        System.out.println("");

        System.out.println("Test 5 = RemoveAfter: Remove Node After 4");
        Node node4 = list.Search(4);
        list.RemoveAfter(node4);
        list.Print();
        System.out.println("");

        System.out.println("Test 6 = RemoveBefore: Remove Node Before 8 ");
        Node node8 = list.Search(8);
        list.RemoveBefore(node8);
        list.Print();
        System.out.println("");

        System.out.println("Test 7 = Search for:  7");
        W11D1Coding.Node searchNode = list.Search(7);
        if (searchNode != null) {
            System.out.println("Found: " + searchNode.data);
        } else {
            System.out.println("Not Found");
        }
        list.Print();
        System.out.println("");

        System.out.println("Test 8 = Sort (Selection Sort): ");
        list.Sort();
        list.Print();
        System.out.println("");
    }
    
    protected Node head;
    protected Node tail;

    public W11D1Coding() {
        this.head = null;
        this.tail = null;
    }

    public static class Node 
    {
        Object data; 
        Node next; 
        Node previous;

        public Node(Object data) {
            this.data = data;
            this.next = null;
            this.previous = null;

        }

    }

    public void Append(Object item) {

        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void Prepend(Object item) {

        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public void InsertAfter(Node currentNode, Node newNode) {

        if (currentNode == null) {
            return;
        }
        
        newNode.previous = currentNode;
        newNode.next = currentNode.next;

        if (currentNode.next != null) {
            currentNode.next.previous = newNode;
        }
        else {
            tail = newNode;
        }

        currentNode.next = newNode;

    }

    public void InsertBefore(Node currentNode, Node newNode) {

        if (currentNode == null) {
            return;
        }
        
        newNode.next = currentNode;
        newNode.previous = currentNode.previous;

        if (currentNode.previous != null) {
            currentNode.previous.next = newNode;
        }
        else {
            head = newNode;
        }
        
        currentNode.previous = newNode;

    }

    public void RemoveAfter(Node newNode) {

        if(newNode == null || newNode.next == null) {
            return;
        }

        Node removeNode = newNode.next;
        newNode.next = removeNode.next;

        if (removeNode.next != null) {
            removeNode.next.previous = newNode;
        }
        else {
            tail = newNode;
        }
        
    }

    public void RemoveBefore(Node newNode) {
        
        if(newNode == null || newNode.previous == null) {
            return;
        }

        Node removeNode = newNode.previous;
        newNode.previous = removeNode.previous;

        if (removeNode.previous != null) {
            removeNode.previous.next = newNode;
        }
        else {
            head = newNode;
        }
        
    }

    public Node Search(Object item) {

        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(item)) {
                return currentNode;
            }
            
            currentNode = currentNode.next;
        }
        return null;

    }

    public void Sort(){
    
        if (head == null) {
            return;
        }

        Node currentNode = head;

        while (currentNode != null) {
            Node smallNode = currentNode;
            Node nextNode = currentNode.next;
            
            while(nextNode != null ){
                if((Integer)nextNode.data < (Integer)smallNode.data){
                    smallNode = nextNode;
                }
                nextNode = nextNode.next;
            }

            if(smallNode != currentNode){
                Object temp = currentNode.data;
                currentNode.data = smallNode.data;
                smallNode.data = temp;
            } 
            
            currentNode = currentNode.next;
        }

    } 

    public void Print() {
        
        Node curNode = head;
        while (curNode != null) {
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }
        System.out.println("null");
    }

}