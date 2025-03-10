package pl.erpix.console.model.argument;

public interface ArgumentType<T> {

    T parse(String input);

    Class<T> getType();

}
