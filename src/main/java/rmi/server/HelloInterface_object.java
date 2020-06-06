package rmi.server;

public interface HelloInterface_object extends java.rmi.Remote {
    public Object sayHello(Object from) throws java.rmi.RemoteException;
}