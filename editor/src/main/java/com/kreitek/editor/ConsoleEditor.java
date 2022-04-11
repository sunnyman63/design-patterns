package com.kreitek.editor;

import com.kreitek.editor.commands.CommandFactory;
import com.kreitek.editor.commands.UndoCommand;
import com.kreitek.editor.memento.EditorCaretaker;
import com.kreitek.editor.memento.Memento;
import com.kreitek.editor.viewtype.BadArgsException;
import com.kreitek.editor.viewtype.PrintTypeFactory;
import com.kreitek.editor.viewtype.PrintTypeInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleEditor implements Editor {

    private final CommandFactory commandFactory = new CommandFactory();
    private ArrayList<String> documentLines = new ArrayList<String>();
    private EditorCaretaker editorCaretaker = EditorCaretaker.getInstance();
    private PrintTypeFactory printTypeFactory = PrintTypeFactory.getInstance();
    private PrintTypeInterface printType = printTypeFactory.getPrintType();

    public ConsoleEditor() throws BadArgsException {
    }

    @Override
    public void run() {
        boolean exit = false;

        while (!exit) {
            String commandLine = waitForNewCommand();
            try {
                Command command = commandFactory.getCommand(commandLine);
                command.execute(documentLines);
                if(!(command instanceof UndoCommand)) {
                    editorCaretaker.push(getState());
                }
                printType.showDocumentLines(documentLines);
                showHelp();
            } catch (BadCommandException e) {
                printType.printErrorToConsole("Bad command");
            } catch (ExitException e) {
                exit = true;
            }
        }
    }

    private Memento getState() {
        ArrayList<String> state = (ArrayList<String>) documentLines.clone();
        return new Memento(state);
    }

    private String waitForNewCommand() {
        printType.printToConsole("Enter a command : ");
        Scanner scanner = new Scanner(System. in);
        return scanner.nextLine();
    }

    private void showHelp() {
        printType.printLnToConsole("To add new line -> a \"your text\"");
        printType.printLnToConsole("To update line  -> u [line number] \"your text\"");
        printType.printLnToConsole("To delete line  -> d [line number]");
    }
}
