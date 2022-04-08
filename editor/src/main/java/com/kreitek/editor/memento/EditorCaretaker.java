package com.kreitek.editor.memento;

import java.util.ArrayList;
import java.util.List;

public class EditorCaretaker {
    List<Memento> mementos = new ArrayList<>();
    private static volatile EditorCaretaker instance = null;

    private EditorCaretaker() {
        if (instance != null) {
            throw new RuntimeException("Usage getInstance() method to create");
        }
    }

    public static EditorCaretaker getInstance() {
        if (instance == null) {
            synchronized(EditorCaretaker.class) {
                if (instance == null) {
                    instance = new EditorCaretaker();
                }
            }
        }
        return instance;
    }

    public void push(Memento memento) {
        mementos.add(memento);
    }

    public Memento pop() {
        if(mementos.size() > 0) {
            mementos.remove(mementos.size()-1);
            Memento memento = new Memento(new ArrayList<>());
            if(mementos.size() >= 1) {
                memento = mementos.get(mementos.size() - 1);
            }
            return memento;
        }
        return null;
    }
}
