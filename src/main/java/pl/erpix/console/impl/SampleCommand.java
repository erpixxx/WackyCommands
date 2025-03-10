package pl.erpix.console.impl;

import pl.erpix.console.ConsoleCommand;
import pl.erpix.console.model.CommandNode;
import pl.erpix.console.model.argument.IntegerArgumentType;
import pl.erpix.console.model.builder.ConsoleCommandBuilder;

public class SampleCommand implements ConsoleCommand {

    @Override
    public CommandNode build() {
        return ConsoleCommandBuilder.keyword("sample")
                .executes(ctx -> {
                    System.out.println("Sample command executed");
                })
                .child(ConsoleCommandBuilder.keyword("sub")
                        .executes(ctx -> {
                            System.out.println("Subcommand executed");
                        })
                        .child(ConsoleCommandBuilder.argument("arg", new IntegerArgumentType())
                                .executes(ctx -> {
                                    System.out.println("Argument: " + ctx.getArgument("arg", Integer.class));
                                })
                                .build())
                        .build())
                .build();
    }

}
