package words;

public class PriorityQueue extends Queue {

    public PriorityQueue(){

    }

    @Override
    public int add(int x){
        Node u = new Node(x);
        if(n == 0){
            head.next = u;
            u.next = tail;
        }
        else {
            Node node = head;
//            if(u.x < node.x){
//                u.next = head;
//                u = head;
//            }
            boolean done = false;
            while (!done) {
                if (u.x <= node.next.x) {
                    u.next = node.next;
                    node.next = u;
                    done = true;
                } else {
                    node = node.next;
                    if (node.next == tail) {
                        node.next = u;
                        u.next = tail;
                        done = true;
                    }
                }
            }
        }
        n++;
        return x;
    }



    public Node deleteMin(){
        if(n == 0){
            return null;
        }
        Node node = head.next;
        head.next = node.next;
        n--;
        return node;
    }
}
