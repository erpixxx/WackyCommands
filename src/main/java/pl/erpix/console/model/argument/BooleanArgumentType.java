package pl.erpix.console.model.argument;

public class BooleanArgumentType implements ArgumentType<Boolean> {

    @Override
    public Boolean parse(String input) {
        return Boolean.getBoolean(input);
    }

    @Override
    public Class<Boolean> getType() {
        return Boolean.class;
    }

}
