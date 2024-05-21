package org.example.SecurityRMI.EX3.Client;

import java.rmi.*;

public interface ICallback extends Remote {
    void doCallback(String message) throws RemoteException;
}

