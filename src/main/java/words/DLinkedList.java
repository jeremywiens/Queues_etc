package words;

public class DLinkedList<T> {
    NodeDLL head = new NodeDLL();
    NodeDLL tail = new NodeDLL();
    int n = 0;
    boolean reversed = false;

    public DLinkedList(){
        head.previous = tail;
        head.next = tail;
        tail.next = head;
        tail.previous = head;
    }

    public NodeDLL add(T data){
        NodeDLL node = new NodeDLL<T>(data);
        addNode(node);
        return node;
    }
    public NodeDLL add(NodeDLL node){
        node = addNode(node);
        return node;
    }
    private NodeDLL addNode(NodeDLL node){
        NodeDLL previous = tail.previous(reversed);
        previous.setNext(reversed, node);
        node.setPrevious(reversed, previous);
        node.setNext(reversed, tail);
        tail.setPrevious(reversed, node);
        n++;
        return node;
    }

    public NodeDLL pop() {
        NodeDLL node = head.next(reversed);
        head.setNext(reversed, node.next(reversed));
        node.next(reversed).setPrevious(reversed, head);
        n--;
        return node;
    }

    public NodeDLL getNode(T data){
        NodeDLL node = head.next(reversed);
        while(true){
            if(node.getData() == data){
                return node;
            }
            if(node.next(reversed) == tail){
                return null;
            }
            node = node.next(reversed);
        }
    }
    public NodeDLL swap(T data){
        NodeDLL node = getNode(data);
        return swap(node);
    }

    public boolean reverse(){
        NodeDLL temp = tail;
        tail = head;
        head = temp;
        reversed = !reversed;
        return reversed;
    }

    public NodeDLL swap(NodeDLL node){

        NodeDLL previous = head;
        NodeDLL current = head.next(reversed);
        NodeDLL next = current.next(reversed);

        if(n < 2){
            return null;
        }
        while(current != node){
            if(next.next(reversed) == tail){
                return null;
            }
            previous = current;
            current = next;
            next = next.next(reversed);
        }
        previous.setNext(reversed, next);
        next.setPrevious(reversed, previous);
        current.setNext(reversed, next.next(reversed));
        next.next(reversed).setPrevious(reversed, current);
        next.setNext(reversed, current);
        current.setPrevious(reversed, next);
        return next;

    }

    public int size(){
        return n;
    }

    public String toString(){
        String DLL = "[";
        NodeDLL node = head.next(reversed);
        while(node != tail){
            DLL = DLL + node.toString() + ", ";
            node = node.next(reversed);
        }
        DLL = DLL + "]";
        return DLL;
    }
}
