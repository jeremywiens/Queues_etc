package words;

public class Queue {

    protected Node head = new Node();
    protected Node tail = new Node();
    protected int n = 0;

    public Queue(){

    }


    public int add(int x){
        Node u = new Node(x);
        add(u);
        return x;
    }
    public Node add(Node u){


        if(n == 0){
            head.next = u;
            u.next = tail;
        }

        else{
            Node previous = head.next;
            while(previous.next != tail) {
                previous = previous.next;
            }
            u.next = tail;
            previous.next = u;
        }
        n++;
        return u;
    }

    public Node remove(){
        if (n == 0) {
            return null;
        }
        Node u = head.next;
        head.next = u.next;
        n--;
        return u;
    }


    public Node swap(Node node){
        Node previous = head;
        Node current = head.next;
        Node next = current.next;

        if(n < 2){
            return null;
        }

        while(current != node && next != tail){
            previous = current;
            current = next;
            next = next.next;
        }

        if(next == tail){
            return node;
        }

        current.next = next.next;
        previous.next = next;
        next.next = node;

        return next;
    }

    public int size(){
        int x = n;
        return x;
    }
}


