package pl.erpix.console.model.argument;

public class StringArgumentType implements ArgumentType<String> {

    @Override
    public String parse(String input) {
        return input;
    }

    @Override
    public Class<String> getType() {
        return String.class;
    }

}
