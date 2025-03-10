package pl.erpix.console.model.builder;

import pl.erpix.console.model.CommandNode;
import pl.erpix.console.model.KeywordCommandNode;

import java.util.ArrayList;
import java.util.List;

public class KeywordNodeBuilder extends CommandNodeBuilder<KeywordNodeBuilder> {

    private final String keyword;
    private final List<String> aliases;

    public KeywordNodeBuilder(String keyword) {
        this.keyword = keyword;
        aliases = new ArrayList<>();
    }

    @Override
    protected KeywordNodeBuilder self() {
        return this;
    }

    public KeywordNodeBuilder aliases(String... aliases) {
        this.aliases.addAll(List.of(aliases));
        return self();
    }

    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public CommandNode build() {
        return new KeywordCommandNode(keyword, getAliases(), getDescription(), getKeywords(), getArguments(), getExecutor());
    }

}
