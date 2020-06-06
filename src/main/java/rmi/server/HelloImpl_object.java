package rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl_object extends UnicastRemoteObject implements HelloInterface_object {
    public HelloImpl_object() throws RemoteException {
        super();
    }

    public Object sayHello(Object from) throws RemoteException {
        System.out.println(("Hello from"+from+"!!"));
        return from;
    }
}