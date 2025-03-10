package pl.erpix.console.model;

import java.util.Collection;
import java.util.List;

public class KeywordCommandNode extends CommandNode {

    private final String keyword;
    private final List<String> aliases;

    public KeywordCommandNode(String keyword, List<String> aliases, String description, Collection<KeywordCommandNode> keywords, Collection<ArgumentCommandNode<?>> arguments, CommandExecutor executor) {
        super(description, keywords, arguments, executor);
        this.keyword = keyword;
        this.aliases = aliases;
    }

    @Override
    public String getName() {
        return keyword;
    }

    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public String toString() {
        return "KeywordCommandNode{" +
                "keyword='" + keyword + '\'' +
                ", aliases=" + aliases +
                ", " + super.toString();
    }
}
