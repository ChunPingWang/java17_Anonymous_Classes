package com.example.example;

import java.util.ArrayList;
import java.util.List;

public class ClientQueue {
    private List<Client> clients = new ArrayList<Client>();
    private List<ClientListener> listeners = new ArrayList<ClientListener>();

    public void addClientListener(ClientListener listener){
        listeners.add(listener);
    }

    public void add(Client client){
        clients.add(client);
        var event = new ClientEvent(client);
        for (ClientListener listener : listeners) {
            listener.clientAdded(event);
        }
    }

    public void remove(Client client){
        clients.remove(client);
        var event = new ClientEvent(client);
        for (ClientListener listener : listeners) {
            listener.clientRemoved(event);
        }
    }

    public int getSize(){
        return clients.size();
    }

}
