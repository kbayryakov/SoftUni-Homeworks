package ClassBoxDataValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] fields = new int[3];

        for (int i = 0; i < fields.length; i++) {
                fields[i] = Integer.parseInt(reader.readLine());
        }

        Box box = new Box(fields[0], fields[1], fields[2]);

        System.out.println("Surface Area - " + box.calculateSurfaceArea());
        System.out.println("Lateral Surface Area - " + box.calculateLateralSurfaceArea());
        System.out.println("Volume – " + box.calculateVolume());
    }
}
