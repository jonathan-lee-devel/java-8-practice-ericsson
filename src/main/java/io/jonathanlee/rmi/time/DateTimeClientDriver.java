package io.jonathanlee.rmi.time;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class DateTimeClientDriver {

    public static void main(String[] args) {
        DateTimeClient client = new DateTimeClientImpl();
        try {
            DateTimeClient stub = (DateTimeClient) UnicastRemoteObject.exportObject(client, 0);
            Registry registry = LocateRegistry.getRegistry(DateTimeServerDriver.REGISTRY_PORT);
            DateTimeServer server = (DateTimeServer) registry.lookup(DateTimeServerDriver.REGISTRY_BIND_NAME);
            server.register(stub, (long) (Math.random()*3000.00));

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

}
