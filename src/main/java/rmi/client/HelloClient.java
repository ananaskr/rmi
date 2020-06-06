package rmi.client;

import rmi.server.HelloInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class HelloClient {

    public static void main(String[] args) throws NotBoundException {
        try{

            Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);
            HelloInterface hello = (HelloInterface) registry.lookup("hello1");
            System.out.println(hello.sayHello("flag"));
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }
}
