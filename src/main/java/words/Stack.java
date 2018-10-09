package words;

public class Stack {
    Queue queue1 = new Queue();
    Queue queue2 = new Queue();


    public Stack() {

    }

    public int push(int x) {
        queue1.add(x);
        return x;
    }

    public Node pop() {
        if (queue1.size() == 0) {
            return null;
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.remove().x);
        }
        Queue temp = new Queue();
        temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        assert queue2.size() == 1;
        return queue2.remove();
    }
    public int size(){
        int x;
        x = queue1.size();
        return x;
    }
}

