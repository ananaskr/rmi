package server;

public interface HelloInterface extends java.rmi.Remote {
    public String sayHello(String from) throws java.rmi.RemoteException;
}
