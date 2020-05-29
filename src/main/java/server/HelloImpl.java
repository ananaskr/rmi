package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements HelloInterface {
    public HelloImpl() throws RemoteException {
        super();
    }

    public String sayHello(String from) throws RemoteException {
        System.out.println(("Hello from"+from+"!!"));
        return "sayHello";
    }
}
