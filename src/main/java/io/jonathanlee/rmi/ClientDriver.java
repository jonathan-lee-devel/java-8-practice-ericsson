package io.jonathanlee.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientDriver {

    public static void main(String[] args) {
        try {
            final Registry registry = LocateRegistry.getRegistry(9999);
            final StringManipulator stringManipulator = (StringManipulator) registry.lookup("stringManipulator");
            final String toUpper = stringManipulator.convertToUpper("lowercase");
            System.out.printf("toUpper: %s\n", toUpper);

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

}
