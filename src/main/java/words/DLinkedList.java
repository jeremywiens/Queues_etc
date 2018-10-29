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
        previous.next = node;
        node.previous = previous;
        node.next = tail;
        tail.previous = node;
        n++;
        return node;
    }

    public NodeDLL pop() {
        NodeDLL node = head.next(reversed);
        head.next = node.next(reversed);
        node.next.previous = head;
        n--;
        return node;
    }

    public NodeDLL getNode(T data){
        NodeDLL node = head.next(reversed);
        while(true){
            if(node.getData() == data){
                return node;
            }
            if(node.next == tail){
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
            if(next == tail){
                return null;
            }
            previous = current;
            current = next;
            next = next.next(reversed);
        }
        previous.next = next;
        next.previous = previous;
        current.next = next.next(reversed);
        next.next = current;
        current.previous = next;
        return next;

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
