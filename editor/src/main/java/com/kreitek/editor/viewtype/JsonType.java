package com.kreitek.editor.viewtype;

import java.util.ArrayList;

public class JsonType extends PrintType implements PrintTypeInterface {

    @Override
    public void showDocumentLines(ArrayList<String> textLines) {
        if (textLines.size() > 0){
            setTextColor(TEXT_YELLOW);
            printLnToConsole("{");
            printLnToConsole("\t\"doc\":[");
            for (int index = 0; index < textLines.size(); index++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("\t\t{\"line\":");
                stringBuilder.append("\""+index+"\",");
                stringBuilder.append("\"text\":");
                stringBuilder.append("\""+textLines.get(index)+"\"}");
                printLnToConsole(stringBuilder.toString());
            }
            printLnToConsole("\t]");
            printLnToConsole("}");
            setTextColor(TEXT_RESET);
        }
    }


}
