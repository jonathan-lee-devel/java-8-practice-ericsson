package io.jonathanlee.rmi.time;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DateTimeServerImpl implements DateTimeServer {

    private final ConcurrentMap<DateTimeClient, Long> clientMap = new ConcurrentHashMap<>();

    @Override
    public void register(DateTimeClient client, long interval) throws RemoteException {
        this.clientMap.put(client, interval);
        Thread clientThread = new Thread(new ClientRequestProcessorThread(client, this.clientMap));
        clientThread.start();
    }

    @Override
    public ConcurrentMap<DateTimeClient, Long> getClientMap() throws RemoteException {
        return this.clientMap;
    }

    private static class ClientRequestProcessorThread implements Runnable {

        private final DateTimeClient client;

        private final ConcurrentMap<DateTimeClient, Long> clientMap;

        public ClientRequestProcessorThread(final DateTimeClient client, final ConcurrentMap<DateTimeClient, Long> clientMap) {
            this.client = client;
            this.clientMap = clientMap;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    this.client.update(new Date().toString());
                    Thread.sleep(this.clientMap.get(this.client));
                } catch (InterruptedException | RemoteException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

    }

}
