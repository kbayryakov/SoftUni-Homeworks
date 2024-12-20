package TrafficLights;

public enum Signal {
    RED, GREEN, YELLOW;

    public static void updateSignal(Signal[] signals) {
        for (int i = 0; i < signals.length; i++) {
            switch (signals[i]) {
                case RED:
                    signals[i] = Signal.GREEN;
                    break;
                case GREEN:
                    signals[i] = Signal.YELLOW;
                    break;
                case YELLOW:
                    signals[i] = Signal.RED;
                    break;
            }
        }
    }

    public static void printSignals(Signal[] signals) {
        for (Signal signal : signals) {
            System.out.print(signal + " ");
        }
        System.out.println();
    }
}
