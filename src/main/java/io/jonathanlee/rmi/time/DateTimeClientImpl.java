package io.jonathanlee.rmi.time;

import java.rmi.RemoteException;

public class DateTimeClientImpl implements DateTimeClient {

    @Override
    public void update(String dateTime) throws RemoteException {
        System.out.println(dateTime);
    }

}
