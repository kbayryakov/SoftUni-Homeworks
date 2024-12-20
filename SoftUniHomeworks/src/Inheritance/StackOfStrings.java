package Inheritance;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {

    private List<String> data;

    public StackOfStrings(List<String> data) {
        this.data = data;
    }

    public StackOfStrings() {
        this(new ArrayList<>());
    }

    public void push(String item) {
        data.add(item);
    }

    public String pop() {
        if (!this.data.isEmpty()) {
            return data.remove(this.data.size() - 1);
        }
        return null;
    }

    public String peek() {
        if (!this.data.isEmpty()) {
            return data.get(this.data.size() - 1);
        }
        return null;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
