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
       node.previous.next = node.next;
       node.next.previous = node.previous;
       n--;
       return node;
    }

    public NodeDLL find(NodeDLL node){
       return find(head, (T)node.getData());
    }
    public NodeDLL find(T data){
       return find(head, data);
    }

    public NodeDLL find(NodeDLL node, T data){
        while(node != tail){
            if(node.getData() == data){
                return node;
            }
            if(node.next == tail){
                return null;
            }
            node = node.next(reversed);
        }
        return null;
    }

    public NodeDLL[] findAll(T data){
       NodeDLL bag[] = new NodeDLL[this.size()];
       int x = 0;
       NodeDLL node = head;
       while(node != tail){
           if(node.getData() == data){
               bag[x] = node;
                x++;
           }
           node = node.next(reversed);

       }


       return bag;
       
    }

}
