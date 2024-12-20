package TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

import static TrafficLights.Signal.printSignals;
import static TrafficLights.Signal.updateSignal;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Signal[] signals = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Signal::valueOf)
                .toArray(Signal[]::new);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {

            updateSignal(signals);

            printSignals(signals);
        }
    }
}
