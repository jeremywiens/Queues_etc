package words;

public class NodeDLL<T> {

    protected NodeDLL next;
    protected NodeDLL previous;
    protected T data;

    public NodeDLL(){

    }
    public NodeDLL(T data){

        this.data = data;

    }

    public T getData() {
        return data;
    }

    public NodeDLL setNext(boolean reversed, NodeDLL node){
        if(reversed == true){
            this.previous = node;
        }
        else {
            this.next = node;
        }
        return node;
    }
    public NodeDLL setPrevious(boolean reversed, NodeDLL node){
        if(reversed == true){
            this.next = node;
        }
        else {
            this.previous = node;
        }
        return node;
    }
    public NodeDLL next(boolean reversed){
        if(reversed == true){
            return previous;
        }
        return next;
    }
    public String toString(){
        String node = data.toString();
        return node;
    }
    public NodeDLL previous(boolean reversed){
        if(reversed == true){
            return next;
        }
        return previous;
    }
}
