package pl.erpix.console.model.builder;

import pl.erpix.console.model.ArgumentCommandNode;
import pl.erpix.console.model.CommandExecutor;
import pl.erpix.console.model.CommandNode;
import pl.erpix.console.model.argument.ArgumentType;

public class ArgumentNodeBuilder<T> extends CommandNodeBuilder<ArgumentNodeBuilder<T>> {

    private final String name;
    private final ArgumentType<T> type;
    private CommandExecutor executor;

    public ArgumentNodeBuilder(String name, ArgumentType<T> type) {
        this.name = name;
        this.type = type;
    }

    @Override
    protected ArgumentNodeBuilder<T> self() {
        return this;
    }

    @Override
    public CommandNode build() {
        return new ArgumentCommandNode<>(name, type, getDescription(), getKeywords(), getArguments(), getExecutor());
    }

}
