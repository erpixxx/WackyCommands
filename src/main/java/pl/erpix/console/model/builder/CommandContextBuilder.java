package pl.erpix.console.model.builder;

import pl.erpix.console.model.CommandContext;

import java.util.HashMap;
import java.util.Map;

public class CommandContextBuilder {

    private final Map<String, Object> arguments = new HashMap<>();

    public CommandContextBuilder addArgument(String name, Object argument) {
        arguments.put(name, argument);
        return this;
    }

    public CommandContext build() {
        return new CommandContext(arguments);
    }

}
