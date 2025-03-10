package pl.erpix.console.model;

import java.util.Map;

public class CommandContext {

    private final Map<String, Object> arguments;

    public CommandContext(Map<String, Object> arguments) {
        this.arguments = arguments;
    }

    public <T> T getArgument(String name, Class<T> type) {
        return type.cast(arguments.get(name));
    }

}
