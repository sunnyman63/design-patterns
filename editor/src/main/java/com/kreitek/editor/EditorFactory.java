package com.kreitek.editor;

import com.kreitek.editor.viewtype.BadArgsException;

public class EditorFactory {
    public Editor getEditor() throws BadArgsException {
        return new ConsoleEditor();
    }
}
