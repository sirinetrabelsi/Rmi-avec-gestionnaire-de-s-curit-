package org.example.SecurityRMI.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReverseInterface extends Remote {
    String reverseString(String s) throws RemoteException;
}
