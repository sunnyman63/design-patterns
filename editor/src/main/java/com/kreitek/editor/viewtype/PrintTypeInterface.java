package com.kreitek.editor.viewtype;

import java.util.ArrayList;

public interface PrintTypeInterface {
    void showDocumentLines(ArrayList<String> textLines);

    void printToConsole(String message);

    void printLnToConsole(String message);

    void printErrorToConsole(String message);
}
