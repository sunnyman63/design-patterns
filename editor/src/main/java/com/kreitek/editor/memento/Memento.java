package com.kreitek.editor.memento;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    private ArrayList<String> state;

    public Memento(ArrayList<String> state) {
        this.state = state;
    }

    public ArrayList<String> getState() {
        return state;
    }
}
