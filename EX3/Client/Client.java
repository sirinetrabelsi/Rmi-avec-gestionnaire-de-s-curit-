package org.example.SecurityRMI.EX3.Client;

import org.example.SecurityRMI.EX3.Server.IServer;

import java.rmi.registry.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Callback callback = new Callback();  // création de l'objet callback
        Registry reg = LocateRegistry.getRegistry("localhost", 1099);
        IServer serveur = (IServer) reg.lookup("Server");
        System.out.println("Démarrage de l'appel");
        serveur.callMeBack(5, "coucou", callback);  // demande de rappel

        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fin du main");
    }
}
