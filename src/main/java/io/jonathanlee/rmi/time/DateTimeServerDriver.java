package io.jonathanlee.rmi.time;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class DateTimeServerDriver {

    public static final int REGISTRY_PORT = 9999;

    public static final String REGISTRY_BIND_NAME = "dateTimeServer";

    private static final DateTimeServer dateTimeServer = new DateTimeServerImpl();

    public static void main(String[] args) {
        try {
            final DateTimeServer stub = (DateTimeServer) UnicastRemoteObject.exportObject(dateTimeServer, 0);
            final Registry registry = LocateRegistry.createRegistry(REGISTRY_PORT);
            registry.rebind(REGISTRY_BIND_NAME, stub);
            System.out.println("Date Time Server ready...");

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}
