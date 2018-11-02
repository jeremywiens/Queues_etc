package words;


public class Node<T> {

    protected Node next;
    protected T data;

    public Node(){

    }
    public Node(T data){

        this.data = data;


    }

    public T getX() {
        return data;
    }
}
