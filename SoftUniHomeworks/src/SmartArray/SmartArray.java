package SmartArray;

import java.util.Arrays;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;
    private int capacity;

    public SmartArray () {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    private void resize () {
        this.capacity *= 2;
        int[] copy = new int[this.capacity];

        System.arraycopy(this.data, 0, copy, 0, this.data.length);
        this.data = copy;
    }

    public void add (int element) {
        if (this.size == this.capacity) {
            resize();
        }

        this.data[this.size++] = element;
    }

    private void checkIndex (int index) {
        if (index < 0 || index >= this.size) {
            String message = String.format("Index %d out of bounds for length %d", index, this.size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    public int getIndex (int index) {
        checkIndex(index);
        return this.data[index];
    }

    private void shrink () {
        this.capacity /= 2;
        int[] copy = new int[this.capacity];

        System.arraycopy(this.data, 0, copy, 0, this.data.length);
        this.data = copy;
    }

    public int remove (int index) {
        int element = this.data[index];

        for (int i = index; i < this.size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[this.size - 1] = 0;

        this.size--;

        if (this.size <= this.capacity / 4) {
            shrink();
        }

        return element;
    }

    public void add (int index, int element) {
        checkIndex(index);
        if (this.size == this.capacity) {
            resize();
        }

        if (index == this.size - 1) {
            add(this.data[this.size - 1]);
            this.data[this.size - 2] = element;
        } else {
            this.size++;
            for (int i = this.size - 1; i > index; i--) {
                this.data[i] = this.data[i - 1];
            }
            this.data[index] = element;
        }
    }

    public boolean contains (int element) {
        for (int i = 0; i < this.size; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public String toString () {
        return Arrays.toString(this.data);
    }
}
