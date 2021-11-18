package io.jonathanlee.rmi.time;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.concurrent.ConcurrentMap;

public interface DateTimeServer extends Remote {

    void register(DateTimeClient client, long interval) throws RemoteException;

    ConcurrentMap<DateTimeClient, Long> getClientMap() throws RemoteException;

}
