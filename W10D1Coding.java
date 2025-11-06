public class W10D1Coding {
    public static void main(String[] args) {
        System.out.println("");
        W10D1Coding list = new W10D1Coding();

        // Test cases printed out

        //Appends these items to the list first 10 then 3 then 7 then 2 then 8
        System.out.println("Test 1 = Append: 10, 3, 7, 2, 8");
        list.Append(10);
        list.Append(3);
        list.Append(7);
        list.Append(2);
        list.Append(8);
        list.Print();
        System.out.println("");

        //Prepends these items to the list first 6 then 4
        System.out.println("Test 2 = Prepend: 6, 4");
        list.Prepend(6);
        list.Prepend(4);
        list.Print();
        System.out.println("");

        //Inserts 5 after 7
        System.out.println("Test 3 = InsertAfter: Insert 5 after 7");
        W10D1Coding.Node node7 = list.Search(7);
        W10D1Coding.Node node5 = new W10D1Coding.Node(5);
        if (node7 != null) {
            list.InsertAfter(node7, node5);
        }
        list.Print();
        System.out.println("");

        //Inserts 9 before 10
        System.out.println("Test 4 = InsertBefore: Insert 9 before 10");
        W10D1Coding.Node node10 = list.Search(10);
        W10D1Coding.Node node9 = new W10D1Coding.Node(9);
        if (node10 != null) {
        list.InsertBefore(node10, node9);
        }
        list.Print();
        System.out.println("");

        //Deletes 2
        System.out.println("Test 5 = Delete: Delete 2");
        list.Delete(2);
        list.Print();
        System.out.println("");

        //Removes the last node
        System.out.println("Test 6 = Remove Last Node: ");
        list.RemoveLastNode();
        list.Print();
        System.out.println("");

        //Searches for 7
        System.out.println("Test 7 = Search for:  7");
        W10D1Coding.Node searchNode = list.Search(7);
        if (searchNode != null) {
            System.out.println("Found: " + searchNode.data);
        } else {
            System.out.println("Not Found");
        }
        list.Print();
        System.out.println("");

        //Finds the length of the list
        System.out.println("Test 8 = Length: ");
        int length = list.Length();
        System.out.print(length);
        System.out.println("");
        list.Print();
        System.out.println("");

        //Checks to see if the list is empty
        System.out.println("Test 9 = isEmpty: ");
        boolean isEmpty = list.isEmpty();
        System.out.print(isEmpty);
        System.out.println("");
        list.Print();
        System.out.println("");
        
        //Sorts the list with bubble sort
        System.out.println("Test 10 = Sort (Bubble Sort): ");
        list.Sort();
        list.Print();
        System.out.println("");
    }
    
    //These Nodes indicate the start and end of the linked list
    private Node head;
    private Node tail;
// Constructor for the linked list and initializes them to be null (empty) at first
    public W10D1Coding() {
        this.head = null;
        this.tail = null;
    }

    // Node class to represent each element in the linked list
    public static class Node 
    {
        Object data; //the data stored in the node
        Node next; //pointer to the next node in the list

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }

    }

    //Adds a node to the end of the linked list
    public void Append(Object item) {

        Node newNode = new Node(item);
        //if the list is empty then the new node is both the head and the tail
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        //if it is not empty then the new node is added after the tail and becomes the new tail
    }

    //Adds a node to the beginning of the linked list
    public void Prepend(Object item) {

        Node newNode = new Node(item);
        //if the list is empty then the new node is both the head and the tail
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        //if it is not empty then the new node is added before the head and becomes the new head
        else {
            newNode.next = head;
            head = newNode;
        }
    }

//Inserts a new node after the current node given
    public void InsertAfter(Node currentNode, Node newNode) {
        //if the list is empty then the new node is both the head and the tail
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        //if it is not empty then the new node is added after the tail and becomes the new tail
        else if (currentNode == tail) {
            tail.next = newNode;
            tail = newNode;
        }
        //inserts a new node after the current node given (between the current node and the next node)
        else {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }

    }

//Inserts a new node before the current node given
    public void InsertBefore(Node currentNode, Node newNode) {
        //if the list is empty then the new node is both the head and the tail
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        //if it is not empty then the new node is added before the head and becomes the new head
        else if (currentNode == head) {
            newNode.next = head;
            head = newNode;
        }
        else {
            Node previousNode = this.head;
            //finds the node before the current node making sure that it is not null and that it is not the current node
            while(previousNode != null && previousNode.next != currentNode) {
                previousNode = previousNode.next;
            }
            //inserts the new node before the current node (between the previous node and the current node)
            if(previousNode != null){
                newNode.next = currentNode;
                previousNode.next = newNode;
            }
            
        }

    }

    //Deletes the given item from the linked list
    public void Delete(Object item) {

        //if the list is empty then there is nothing to delete
        if (head == null) {
            return;
        }

        //if the item that is to be deleted is the head then move the head to the next node
        if (head.data.equals(item)) {
            head = head.next;
            //if head is null after deletion then set tail to null as well
            if (head == null) {
                tail = null;
            }
            return;
        }
        
        Node previousNode = head;
        Node currentNode = head.next;
        //go through the list to find the item that will be deleted making sure that the current node is not null and that the data does not equal the item to be deleted
        while (currentNode != null && !currentNode.data.equals(item)) {
            //the previous node becomes the current node and the current node becomes the next node
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
// if the current node is not null then the item was found and it is deleted by making the previous node point to the next node of the current node
        if (currentNode != null) {
            previousNode.next = currentNode.next;
            if (currentNode == tail) {
                tail = previousNode;
            }
        }
    }
    
    //searches through the linked list for the item given
    public Node Search(Object item) {

        Node currentNode = head;
        //contuine going through the linked list until current node is null
        while (currentNode != null) {
            //if the current noded equals the item then we have found the item that we were searching for and return it
            if (currentNode.data.equals(item)) {
                return currentNode;
            }
            //moves to the next node
            currentNode = currentNode.next;
        }
// if the item was not found the null is return to show this
        return null;

    }

    //removes the last node in the linked list
    public void RemoveLastNode() {

        Node currentNode = head;
        //if head is equal to tail then there is only one node in the list and it is removed
        if(head == tail){
            head = null;
            tail = null;
        }

        //contuines to go through the linked list until just before the tail
        while (currentNode.next != tail) {
            currentNode = currentNode.next;
        }   
        // removes the last node of the linked list and then updates the tail 
        currentNode.next = null;
        tail = currentNode;
        
    }

    //finds the length of the linked list
    public int Length() {
        int count = 0;
        Node currentNode = head;
        //goes through the nodes and counts how many there are until the end
        while (currentNode != null) {
            //counts the amount
            count++;
            //moves to the next node
            currentNode = currentNode.next;
        }
        return count;
    }

    //checks to see if the linked list is empty but checking if head is null because if it is then it shows that the linked list is empty
    public boolean isEmpty() {
        return head == null;
    }

/*
 * This is a bubble sort algorithm for a singly linked list
 * It keeps swapping and comparing the nodes
 * If the data is in the wrong place it swaps it until it is in the correct place
 * It continues doing this until no swaps are made and has gone through the whole list
 */

    public void Sort(){
        //if the list is empty or has only one node then nothing needs to be done
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped = true;
        //keep looping until no swaps are made
        while (swapped == true) {
            swapped = false;
            Node currentNode = head;
            //Contuine checking until the end of the list
            while (currentNode.next != null) {
                //compare current node data with the next node data
                if ((Integer)currentNode.data > (Integer)currentNode.next.data) {
                    //Swap the data
                    Object temp = currentNode.data;
                    currentNode.data = currentNode.next.data;
                    currentNode.next.data = temp;
                    swapped = true;
                }
                //Move to the next node
                currentNode = currentNode.next;
            }
        }
    }

// prints the linked list starting from the head to the tail and ends with null to show that the tail points to null
    public void Print() {
        Node curNode = head;
        while (curNode != null) {
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }
        System.out.println("null");
    }

}


    

