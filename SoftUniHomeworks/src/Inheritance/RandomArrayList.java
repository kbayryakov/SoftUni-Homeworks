package Inheritance;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object>{
    private Random random = new Random();
    public Object getRandomElement() {
        int randomNum = this.random.nextInt(super.size());
         Object element = super.get(randomNum);
         super.remove(randomNum);
         return element;
    }
}
