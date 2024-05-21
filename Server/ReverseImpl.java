package org.example.SecurityRMI.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ReverseImpl extends UnicastRemoteObject implements ReverseInterface {
    public ReverseImpl() throws RemoteException {
        super();
    }

    public String reverseString(String s) throws RemoteException {
        return new StringBuilder(s).reverse().toString();
    }
}

