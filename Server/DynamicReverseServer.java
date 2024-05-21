//EX2
package org.example.SecurityRMI.Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RMISecurityManager;
import java.util.Properties;
import java.rmi.server.RMIClassLoader;
import java.rmi.Remote;

public class DynamicReverseServer {
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("Serveur : Construction de l'implementation");

            Properties p = System.getProperties();
            String url = p.getProperty("java.rmi.server.codebase");
            Class<?> classeServeur = RMIClassLoader.loadClass(url, "FabReverseImpl");
            registry.rebind("Fabrique", (Remote) classeServeur.getDeclaredConstructor().newInstance());

            System.out.println("Serveur prêt.");
            System.out.println("Attente des invocations des clients ...");
        } catch (Exception e) {
            System.out.println("Erreur de liaison de l'objet Fabrique");
            e.printStackTrace();
        }
    }
}

