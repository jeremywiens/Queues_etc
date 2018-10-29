package words;

public class PriorityQueue extends Queue {

    protected PriorityNode head = new PriorityNode();
    protected PriorityNode tail = new PriorityNode();

    public PriorityQueue(){

    }

    @Override
    public Node add(Node u){
        int x = (int)u.getX();
        add(x);
        return u;
    }
    @Override
    public PriorityNode add(int x){
        PriorityNode u = new PriorityNode(x);
        if(n == 0){
            head.next = u;
            u.next = tail;
        }
        else {
            PriorityNode node = head;

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
        return u;
    }



    public Node deleteMin(){
        if(n == 0){
            return null;
        }
        PriorityNode node = head.next;
        head.next = node.next;
        n--;
        return node;
    }
}
