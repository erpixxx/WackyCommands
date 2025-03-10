package pl.erpix.console.model;

@FunctionalInterface
public interface CommandExecutor {

    void execute(CommandContext ctx);

}
