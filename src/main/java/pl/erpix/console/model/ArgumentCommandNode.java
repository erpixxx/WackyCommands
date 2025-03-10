package pl.erpix.console.model;

import pl.erpix.console.model.argument.ArgumentType;

import java.util.Collection;

public class ArgumentCommandNode<T> extends CommandNode {

    private final String name;
    private final ArgumentType<T> type;

    public ArgumentCommandNode(String name, ArgumentType<T> type, String description, Collection<KeywordCommandNode> keywords, Collection<ArgumentCommandNode<?>> arguments, CommandExecutor executor) {
        super(description, keywords, arguments, executor);
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    public T parse(String input) {
        return type.parse(input);
    }

    public ArgumentType<T> getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ArgumentCommandNode{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", " + super.toString();
    }
}
