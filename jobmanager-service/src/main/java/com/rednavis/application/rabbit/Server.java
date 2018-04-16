package com.rednavis.application.rabbit;

public enum Server {
    REMOTE("192.168.50.142"),
    LOCAL("127.0.0.1");

    private  String value;

    private Server(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
