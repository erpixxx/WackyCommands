package pl.erpix.console.model.argument;

public class IntegerArgumentType implements ArgumentType<Integer> {

    @Override
    public Integer parse(String input) {
        return Integer.parseInt(input);
    }

    @Override
    public Class<Integer> getType() {
        return Integer.class;
    }

}
