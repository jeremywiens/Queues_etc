package words;

public class NodeDLL<T> {

    NodeDLL next;
    NodeDLL previous;
    private T data;

    public NodeDLL(){

    }
    public NodeDLL(T data){

        this.data = data;

    }

    public T getData() {
        return data;
    }
    public NodeDLL next(boolean reversed){
        if(reversed == true){
            return previous;
        }
        return next;
    }
    public NodeDLL previous(boolean reversed){
        if(reversed == true){
            return previous;
        }
        return next;
    }
}
