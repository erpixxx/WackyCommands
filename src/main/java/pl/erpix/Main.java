package pl.erpix;

import pl.erpix.console.ConsoleCommandProcessor;
import pl.erpix.console.impl.SampleCommand;
import pl.erpix.console.model.CommandNode;

public class Main {

    public static void main(String[] args) {

        ConsoleCommandProcessor processor = new ConsoleCommandProcessor();

        CommandNode sampleCmd = new SampleCommand().build();

        processor.register(sampleCmd);

        processor.process("sample");
        processor.process("sample sub");
        processor.process("sample sub 123");

    }

}