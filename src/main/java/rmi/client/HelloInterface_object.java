package rmi.client;

import java.rmi.Remote;

public interface HelloInterface_object extends Remote {
    public Object sayHello(Object from) throws java.rmi.RemoteException;
}
