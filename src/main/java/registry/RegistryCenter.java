package registry;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RegistryCenter {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        while(true);

    }

}
