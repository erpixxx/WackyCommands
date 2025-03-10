package pl.erpix.console.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class CommandNode {

    private final Map<String, CommandNode> children = new LinkedHashMap<>();
    private final Map<String, KeywordCommandNode> keywords = new LinkedHashMap<>();
    private final Map<String, ArgumentCommandNode<?>> arguments = new LinkedHashMap<>();
    private final String description;
    private final CommandExecutor executor;

    protected CommandNode(String description, Collection<KeywordCommandNode> keywords, Collection<ArgumentCommandNode<?>> arguments, CommandExecutor executor) {
        this.description = description;
        this.executor = executor;
        keywords.forEach(keyword -> {
            this.children.put(keyword.getName(), keyword);
            this.keywords.put(keyword.getName(), keyword);
        });
        arguments.forEach(argument -> {
            this.children.put(argument.getName(), argument);
            this.arguments.put(argument.getName(), argument);
        });
    }

    public abstract String getName();

    public void execute(CommandContext context) {
        executor.execute(context);
    }

    public boolean isExecutable() {
        return executor != null;
    }

    public CommandNode getChild(String name) {
        return children.get(name);
    }

    public Collection<CommandNode> getChildren() {
        return children.values();
    }

    public Collection<KeywordCommandNode> getKeywords() {
        return keywords.values();
    }

    public ArgumentCommandNode<?> getArgument(String name) {
        return arguments.get(name);
    }

    public Collection<ArgumentCommandNode<?>> getArguments() {
        return arguments.values();
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "CommandNode{" +
                "children=" + children +
                ", keywords=" + keywords +
                ", arguments=" + arguments +
                ", description='" + description + '\'' +
                '}';
    }

}
