package com.kreitek.editor;

import com.kreitek.editor.viewtype.BadArgsException;
import com.kreitek.editor.viewtype.PrintTypeFactory;

public class Application {

    public static void main(String[] args) throws BadArgsException {
        try {
            PrintTypeFactory printTypeFactory = PrintTypeFactory.getInstance();
            printTypeFactory.setType(args[0]);
            EditorFactory editorFactory = new EditorFactory();
            Editor editor = editorFactory.getEditor();
            editor.run();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m");
            System.out.println("Debe pasar un parametro (\"text\" o \"json\") a la ejecución del programa.");
        } catch (BadArgsException e) {
            System.out.println("\u001B[31m");
            System.out.println("El parametro debe ser \"text\" o \"json\".");
        }
    }

}
