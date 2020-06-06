package rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {
    public static void main(String[] args) throws Exception {
        try {
            HelloImpl remote  = new HelloImpl();
            Registry registry = LocateRegistry.getRegistry(1099);
            registry.bind("hello1", remote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}