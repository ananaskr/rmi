package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer_object {
    public static void main(String[] args) throws Exception {
        try {
            HelloImpl_object remote  = new HelloImpl_object();
            Registry registry = LocateRegistry.getRegistry(1099);
            registry.bind("hello1", remote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
