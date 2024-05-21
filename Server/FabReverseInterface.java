package org.example.SecurityRMI.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FabReverseInterface extends Remote {
    ReverseInterface newReverse() throws RemoteException;
}

