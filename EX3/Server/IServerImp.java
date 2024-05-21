package org.example.SecurityRMI.EX3.Server;

import org.example.SecurityRMI.EX3.Client.ICallback;

import java.rmi.*;
import java.rmi.server.*;


public class IServerImp extends UnicastRemoteObject implements IServer {
    public IServerImp() throws RemoteException {
        super();
    }

    public void callMeBack(int time, String param, ICallback callback) throws RemoteException {
        Servant servant = new Servant(time, param, callback);
        servant.start();  // démarrage du servant
    }
}

