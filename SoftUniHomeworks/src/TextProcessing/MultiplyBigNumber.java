package TextProcessing;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num1 = scanner.nextLine();
        int num2 = Integer.parseInt(scanner.nextLine());
        StringBuilder finalResult = new StringBuilder();
        boolean isZero = true;

        for (int i = 0; i < num1.length() ; i++) {
            int num = Integer.parseInt(String.valueOf(num1.charAt(i)));
            if (num != 0) {
                isZero = false;
                break;
            }
        }

        if (isZero && num2 == 0) {
            System.out.println(0);
            return;
        }

        int remain = 0;
        int result = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int num = Integer.parseInt(String.valueOf(num1.charAt(i)));
            result = num * num2 + remain;
            remain = result / 10;

            if (i == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(result);
                if (sb.length() > 1) {
                    sb.reverse();
                }
                finalResult.append(sb);
            } else {
                finalResult.append(result % 10);
            }

        }

        if (isZero) {
            System.out.println(0);
        } else if (num2 == 0) {
            System.out.println(0);
        } else {
            String str = finalResult.reverse().toString();
            str = str.replaceFirst("^0+", "");
            System.out.println(str);
        }

    }
}
