package org.example.SecurityRMI.Server;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ReverseClient {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Utilisation : java ReverseClient ch1 ch2");
            System.exit(0);
        }

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }

        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            FabReverseInterface fabrique = (FabReverseInterface) reg.lookup("Fabrique");
            ReverseInterface ReverseObj1 = fabrique.newReverse();
            ReverseInterface ReverseObj2 = fabrique.newReverse();

            String result = ReverseObj1.reverseString(args[0]);
            System.out.println("L'inverse de " + args[0] + " est " + result + "\n");

            String result1 = ReverseObj2.reverseString(args[1]);
            System.out.println("L'inverse de " + args[1] + " est " + result1 + "\n");
        } catch (Exception e) {
            System.out.println("Erreur d'acces a l'objet distant.");
            e.printStackTrace();
        }
    }
}

