package io.jonathanlee.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringManipulator extends Remote {

    String convertToUpper(String string) throws RemoteException;

}
