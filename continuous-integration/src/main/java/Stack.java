import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack implements IStack {
    private List<Integer> elements = new ArrayList<Integer>();
    private int length = 0;

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return (length == 0);
    }

    @Override
    public void push(int elem) {
        elements.add(elem);
        length++;
    }

    @Override
    public int pop() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        int elem = elements.remove(length-1);
        length--;

        return elem;
    }
}
