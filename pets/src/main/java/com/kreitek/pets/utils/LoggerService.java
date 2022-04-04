package com.kreitek.pets.utils;

public class LoggerService {

    private static LoggerService instance = null;
    private int contador = 0;

    private LoggerService() {}

    public static LoggerService getInstance() {
        if(instance == null) {
            instance = new LoggerService();
        }
        return instance;
    }

    public void debug(String mensaje) {
        System.out.println("[debug]["+contador+"] " + mensaje);
        contador++;
    }




}
