package CustomStack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class CustomStack {
    private static final int INITIAL_CAPACITY = 4;
    private int[] items;
    private int size;
    private int capacity;

    public CustomStack () {
        this.capacity = INITIAL_CAPACITY;
        this.items = new int[capacity];
    }

    public int getSize () {
        return this.size;
    }

    private void resize () {
        this.capacity *= 2;
        int[] copy = new int[this.capacity];

        System.arraycopy(this.items, 0, copy, 0, this.items.length);
        this.items = copy;
    }

    public void push (int element) {
        if (size == capacity) {
            resize();
        }
        this.items[this.size++] = element;
    }

    public int pop () {
        checkEmpty();

        int element = this.items[this.size - 1];
        this.size--;
        return element;
    }

    private void checkEmpty () {
        if (this.size <= 0) {
            throw new IndexOutOfBoundsException("StackOfStrings is empty");
        }
    }

    public int peek () {
        checkEmpty();

        return this.items[this.size - 1];
    }

}
