package words;

public class DLinkedList<T> {
    NodeDLL head;
    NodeDLL tail;
    int n = 0;
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
        NodeDLL previous = tail.previous;
        previous.next = node;
        node.previous = previous;
        node.next = tail;
        tail.previous = node;
        n++;
        return node;
    }

    public NodeDLL pop() {
        NodeDLL node = head.next;
        head.next = node.next;
        node.next.previous = head;
        n--;
        return node;
    }

    public NodeDLL getNode(T data){
        NodeDLL node = head.next;
        while(true){
            if(node.getData() == data){
                return node;
            }
            if(node.next == tail){
                return null;
            }
            node = node.next;
        }
    }
    public NodeDLL swap(T data){
        NodeDLL node = getNode(data);
        swap(node);
    }
    public NodeDLL swap(NodeDLL node){

        NodeDLL previous = head;
        NodeDLL current = head.next;
        NodeDLL next = current.next;

        if(n < 2){
            return null;
        }
        while(current != node){
            if(next == tail){
                return null;
            }
            previous = current;
            current = next;
            next = next.next;
        }
        previous.next = next;
        next.previous = previous;
        current.next = next.next;
        next.next = current;
        current.previous = next;
        return next;

    }
}
