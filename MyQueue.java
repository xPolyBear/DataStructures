public class MyQueue extends W11D1Coding implements Queue{
    
    public void enqueue(Object item) {
        Append(item);
    }

    public Object dequeue() {

        if(head == null) {
            return null;
        }

        Object data = head.data;
        head = head.next;
        if(head != null) {
            head.previous = null;
        } else {
            tail = null;
        }

        return data;
    }

    public Object front() {

        if(head != null) {
            return head.data;
        } else {
            return null;
        }
        
    }

}
