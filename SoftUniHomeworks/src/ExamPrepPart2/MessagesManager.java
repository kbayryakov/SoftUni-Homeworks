package ExamPrepPart2;

import com.sun.source.tree.IfTree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int possibleMessages = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> messages = new LinkedHashMap<>();

        String action;
        while (!"Statistics".equals(action = scanner.nextLine())) {
            String[] commands = action.split("=");
            String command = commands[0];

            if (command.equals("Add")) {
                
                String username = commands[1];
                int sent = Integer.parseInt(commands[2]);
                int received = Integer.parseInt(commands[3]);
                int allMessages = sent + received;
                
                if (!messages.containsKey(username)) {
                    messages.put(username, allMessages);
                }

            } else if (command.equals("Message")) {
                String sender = commands[1];
                String receiver = commands[2];

                if (messages.containsKey(sender) && messages.containsKey(receiver)) {

                    int senderMessagesCount = messages.get(sender) + 1;
                    messages.put(sender, senderMessagesCount);

                    int receiverMessagesCount = messages.get(receiver) + 1;
                    messages.put(receiver, receiverMessagesCount);

                    if (messages.get(sender) >= possibleMessages) {
                        messages.remove(sender);
                        System.out.printf("%s reached the capacity!\n", sender);
                    }

                    if (messages.get(receiver) >= possibleMessages) {
                        messages.remove(receiver);
                        System.out.printf("%s reached the capacity!\n", receiver);
                    }
                }
                
            } else if (command.equals("Empty")) {

                String username = commands[1];

                if (username.equals("All")) {
                    messages.clear();
                } else {
                    messages.remove(username);
                }

            }

        }

        System.out.println("Users count: " + messages.size());
        for (var kvp : messages.entrySet()) {
            System.out.printf("%s - %d\n", kvp.getKey(), kvp.getValue());
        }
    }
}
