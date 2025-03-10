package pl.erpix.console;

import pl.erpix.CommandBase;
import pl.erpix.console.model.CommandNode;

public interface ConsoleCommand extends CommandBase<CommandNode> {

    @Override
    CommandNode build();

}
