package Generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    public static<T> T[] create (int length, T item) {
        Object[] arr = new Object[length];
        for (int i = 0; i < length; i++) {
            arr[i] = item;
        }
        return (T[]) arr;
    }

    public static<T> T[] create (Class<T> tClass, int length, T item) {
        T[] arr = (T[]) Array.newInstance(tClass, length);
        for (int i = 0; i < length; i++) {
            arr[i] = item;
        }
        return (T[]) arr;
    }
}
