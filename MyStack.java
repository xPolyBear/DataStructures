public class MyStack extends W11D1Coding implements Stack{

    
    public void push(Object item) {
        Append(item);
    }

    
    public Object pop() {
        if (tail == null) {
            return null;
        }
        Object data = tail.data;

        if(tail.previous != null) {
            tail = tail.previous;
            tail.next = null;
        } 
        else {
            head = null;
            tail = null;
        }

        return data;
    }

    
    public Object peek() {
        if(tail != null) {
            return tail.data;
        }
        else {
            return null;
        }
    }

}

