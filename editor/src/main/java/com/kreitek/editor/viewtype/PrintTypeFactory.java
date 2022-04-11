package com.kreitek.editor.viewtype;

public class PrintTypeFactory {

    private String type;
    private static volatile PrintTypeFactory instance = null;

    private PrintTypeFactory() {
        if (instance != null) {
            throw new RuntimeException("Usage getInstance() method to create");
        }
    }

    public static PrintTypeFactory getInstance() {
        if (instance == null) {
            synchronized(PrintTypeFactory.class) {
                if (instance == null) {
                    instance = new PrintTypeFactory();
                }
            }
        }
        return instance;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PrintTypeInterface getPrintType() throws BadArgsException {
        switch (this.type) {
            case "text": return new TextType();
            case "json": return new JsonType();
            default: throw new BadArgsException();
        }
    }

}
