package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.memento.EditorCaretaker;
import com.kreitek.editor.memento.Memento;

import java.util.ArrayList;

public class UndoCommand implements Command {

    private EditorCaretaker editorCaretaker;

    public UndoCommand() {
        editorCaretaker = EditorCaretaker.getInstance();
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        Memento memento = editorCaretaker.pop();
        if(memento != null) {
            documentLines.clear();
            documentLines.addAll(memento.getState());
        } else {
            System.out.println("\u001B[33m");
            System.out.println("No hay pasos a los que volver");
            System.out.println("\u001B[0m");
        }
    }
}
