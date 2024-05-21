package org.example.SecurityRMI.Server;

import org.example.SecurityRMI.Server.FabReverseInterface;
import org.example.SecurityRMI.Server.ReverseImpl;
import org.example.SecurityRMI.Server.ReverseInterface;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class FabReverseImpl extends UnicastRemoteObject implements FabReverseInterface {
    public FabReverseImpl() throws RemoteException {
        super();
    }

    public ReverseInterface newReverse() throws RemoteException {
        return new ReverseImpl();
    }
}

