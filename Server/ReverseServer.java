package org.example.SecurityRMI.Server;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ReverseServer {
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("Serveur : Construction de l'implementation");
            FabReverseImpl fab = new FabReverseImpl();
            System.out.println("Objet Fabrique lie dans le RMIregistry");
            registry.rebind("Fabrique", fab);
            System.out.println("Serveur prêt.");
            System.out.println("Attente des invocations des clients ...");
        } catch (Exception e) {
            System.out.println("Erreur de liaison de l'objet Fabrique");
            e.printStackTrace();
        }
    }
}

