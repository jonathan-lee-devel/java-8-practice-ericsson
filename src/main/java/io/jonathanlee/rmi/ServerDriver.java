package io.jonathanlee.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerDriver {

    public static void main(String[] args) {
        final StringManipulator stringManipulator = new StringManipulatorImpl();
        try {
            final StringManipulator stub = (StringManipulator) UnicastRemoteObject.exportObject(stringManipulator, 0);
            final Registry registry = LocateRegistry.createRegistry(9999);
            registry.rebind("stringManipulator", stub);
            System.out.println("String manipulator server ready...");

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
