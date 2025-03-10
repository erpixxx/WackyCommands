package pl.erpix.console.model.argument;

public class DoubleArgumentType implements ArgumentType<Double> {

    @Override
    public Double parse(String input) {
        return Double.parseDouble(input);
    }

    @Override
    public Class<Double> getType() {
        return Double.class;
    }

}
