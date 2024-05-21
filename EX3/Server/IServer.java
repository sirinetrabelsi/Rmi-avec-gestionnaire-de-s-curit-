package org.example.SecurityRMI.EX3.Server;

import org.example.SecurityRMI.EX3.Client.ICallback;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
    void callMeBack(int time, String param, ICallback callback) throws RemoteException;
}

