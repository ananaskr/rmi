package rmi.client;

import java.rmi.Remote;

public interface HelloInterface extends Remote {
    public String sayHello(String from) throws java.rmi.RemoteException;
}
