//EX2
package org.example.SecurityRMI.Clent;

import java.rmi.server.RMIClassLoader;
import java.util.Properties;
import java.lang.reflect.Constructor;
import java.rmi.RMISecurityManager;

public class DynamicClient {
    public DynamicClient(String[] args) throws Exception {
        Properties p = System.getProperties();
        String url = p.getProperty("java.rmi.server.codebase");
        Class<?> classeClient = RMIClassLoader.loadClass(url, "ReverseClient");
        Constructor<?>[] constructors = classeClient.getConstructors();
        constructors[0].newInstance(new Object[]{args});
    }

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            new DynamicClient(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

