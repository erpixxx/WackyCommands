package pl.erpix.console.model.builder;

import pl.erpix.console.model.ArgumentCommandNode;
import pl.erpix.console.model.CommandExecutor;
import pl.erpix.console.model.CommandNode;
import pl.erpix.console.model.KeywordCommandNode;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class CommandNodeBuilder<T extends CommandNodeBuilder<T>> {

    private final Map<String, KeywordCommandNode> keywords = new LinkedHashMap<>();
    private final Map<String, ArgumentCommandNode<?>> arguments = new LinkedHashMap<>();
    private CommandExecutor executor;
    private String description;

    public T child(CommandNode node) {
        if (node instanceof KeywordCommandNode) {
            keywords.put(node.getName(), (KeywordCommandNode) node);
        }
        else if (node instanceof ArgumentCommandNode) {
            arguments.put(node.getName(), (ArgumentCommandNode<?>) node);
        }
        return self();
    }

    public Collection<KeywordCommandNode> getKeywords() {
        return keywords.values();
    }

    public Collection<ArgumentCommandNode<?>> getArguments() {
        return arguments.values();
    }

    public T description(String description) {
        this.description = description;
        return self();
    }

    public String getDescription() {
        return description;
    }

    public T executes(CommandExecutor executor) {
        this.executor = executor;
        return self();
    }

    public CommandExecutor getExecutor() {
        return executor;
    }

    protected abstract T self();

    public abstract CommandNode build();

}
