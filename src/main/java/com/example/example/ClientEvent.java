package com.example.example;

public class ClientEvent {

    private Client client;

    public ClientEvent(Client client) {
        this.client = client;
    }

    public String getName(){
        return this.client.name;
    }

    public String getIp(){
        return this.client.ip;
    }
}
