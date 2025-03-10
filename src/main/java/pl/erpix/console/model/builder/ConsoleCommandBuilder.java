package pl.erpix.console.model.builder;

import pl.erpix.console.model.argument.ArgumentType;

// wrapper
public class ConsoleCommandBuilder {

    public static KeywordNodeBuilder keyword(String keyword) {
        return new KeywordNodeBuilder(keyword);
    }

    public static <T> ArgumentNodeBuilder<T> argument(String name, ArgumentType<T> type) {
        return new ArgumentNodeBuilder<>(name, type);
    }

}
