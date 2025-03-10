package pl.erpix.console;

import pl.erpix.console.model.ArgumentCommandNode;
import pl.erpix.console.model.CommandNode;
import pl.erpix.console.model.builder.CommandContextBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConsoleCommandProcessor {

    private final Map<String, CommandNode> commands = new LinkedHashMap<>();

    public void process(String input) {
        CommandContextBuilder builder = new CommandContextBuilder();
        input = input.trim();

        CommandNode currentNode = null;
        int lastSpace = 0;
        // expectedChar = ' '

        for (int i = 0; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) == ' ') {
                String token = input.substring(lastSpace, i).trim();
                lastSpace = i + 1;

                if (token.isEmpty()) continue;

                if (currentNode == null) {
                    currentNode = commands.get(token);
                    if (currentNode == null) return; // Handle unknown command
                }
                else {
                    CommandNode child = currentNode.getChild(token);
                    if (child != null) {
                        currentNode = child;
                    }
                    else {
                        for (ArgumentCommandNode<?> arg : currentNode.getArguments()) {
                            Object parsed = arg.parse(token);
                            if (parsed != null) {
                                builder.addArgument(arg.getName(), parsed);
                                currentNode = arg;
                                break;
                            }
                        }
                    }
                }
            }
        }

        if (currentNode != null) {
            if (currentNode.isExecutable())
                currentNode.execute(builder.build());
            else
                System.out.println("Command not executable");
        }
    }

    public void register(CommandNode command) {
        commands.put(command.getName(), command);
    }

}
