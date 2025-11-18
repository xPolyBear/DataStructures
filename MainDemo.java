public class MainDemo {
    public static void main(String[] args) {

        Stack theStack = new MyStack();
        
        System.out.println();
        System.out.println("Push 10, 22, 3, 13, 7");
        System.out.println("After the Push: ");
        theStack.push(10);
        theStack.push(22);
        theStack.push(3);
        theStack.push(13);
        theStack.push(7);
        theStack.Print();

        System.out.println("Pop: " + theStack.pop());
        System.out.println("After the Pop: ");
        theStack.Print();

        System.out.println("Peek " + theStack.peek());

        System.out.println();
        Queue theQueue = new MyQueue();
        System.out.println("Enqueue 11, 33, 1, 99, 2");
        System.out.println("After the Enqueue: ");
        theQueue.enqueue(11);
        theQueue.enqueue(33);
        theQueue.enqueue(1);
        theQueue.enqueue(99);
        theQueue.enqueue(2);
        theQueue.Print();

        System.out.println("Dequeue " + theQueue.dequeue());
        System.out.println("After the Dequeue: ");
        theQueue.Print();

        System.out.println("Front " + theQueue.front());











    }
}
