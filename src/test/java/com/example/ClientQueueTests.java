package com.example;

import com.example.example.Client;
import com.example.example.ClientEvent;
import com.example.example.ClientListener;
import com.example.example.ClientQueue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientQueueTests {

    private Client c1;

    private Client c2;

    private ClientQueue queue;
    @BeforeEach
    public void setUp(){
        System.out.println("Set Up Method");
        this.c1 = new Client("127.0.0.1", "Chun Ping Wang");
        this.c2 = new Client("192.168.1.1", "Rex Wang");
        queue = new ClientQueue();

        queue.addClientListener(new ClientListener() {
            @Override
            public void clientAdded(ClientEvent event) {
                System.out.printf("%s connected from %s\n", event.getName(), event.getIp());
            }

            @Override
            public void clientRemoved(ClientEvent event) {
                System.out.printf("%s removed from %s\n", event.getName(), event.getIp());
            }
        });
    }

    @Test
    public void add_client_to_queue_test(){
        queue.add(c1);
        assertEquals(1, queue.getSize());
        queue.add(c2);
        assertEquals(2, queue.getSize());
    }


    @Test
    public void remove_client_to_queue_test(){
        queue.add(c1);
        queue.add(c2);
        assertEquals(2, queue.getSize());
        queue.remove(c1);
        assertEquals(1, queue.getSize());
        queue.remove(c2);
        assertEquals(0, queue.getSize());
    }

}
