package words;

public class Bag<T> extends DLinkedList<T>{

   public Bag(){
       head.previous = tail;
       head.next = tail;
       tail.next = head;
       tail.previous = head;
    }

    public NodeDLL remove(T data){
       NodeDLL node = find(data);
       return remove(node, true);

    }

    public NodeDLL remove(NodeDLL node){
       return remove((T)node.getData());
    }

    public NodeDLL remove(NodeDLL node, boolean inBag){
       node.previous = node.next;
       node.next.previous = node.previous;
       return node;
    }

    public NodeDLL find(NodeDLL node){
       return find(head, (T)node.getData());
    }
    public NodeDLL find(T data){
       return find(head, data);
    }

    public NodeDLL find(NodeDLL node, T data){
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

    public Bag<T> findAll(T data){
       Bag<T> bag = new Bag<>();

       NodeDLL node = head;
       while(node != null){
           node = find(node, data);
           if(node != null){
               bag.add(node);
           }
       }

       return bag;
       
    }

}
