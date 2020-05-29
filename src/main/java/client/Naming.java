package client;

import java.io.IOException;
import java.lang.reflect.Field;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.Operation;
import java.rmi.server.RemoteRef;


public class Naming {


    private Naming() {}

    public static Field getField(final Class<?> clazz, final String fieldName) {
        Field field = null;
        try {
            field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
        } catch (NoSuchFieldException ex) {
            if (clazz.getSuperclass() != null)
                field = getField(clazz.getSuperclass(), fieldName);
        }
        return field;
    }

    public static Remote lookup(Registry registry, Object obj)
            throws Exception, IOException, ClassNotFoundException, RuntimeException, RemoteException, NotBoundException {

        Field ref1 = getField(registry.getClass(),"ref");
        RemoteRef ref = (RemoteRef) ref1.get(registry);

        long interfaceHash = 4905912898345647071L;

        Field operations1 = getField(registry.getClass(),"operations");
        java.rmi.server.Operation[] operations = (Operation[]) operations1.get(registry);



        try {
            java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) registry, operations, 2, interfaceHash);
            try {
                java.io.ObjectOutput out = call.getOutputStream();
                out.writeObject(obj); // arm obj
            } catch (java.io.IOException e) {
                throw new java.rmi.MarshalException("error marshalling arguments", e);
            }
            ref.invoke(call);
            java.rmi.Remote $result;
            try {
                java.io.ObjectInput in = call.getInputStream();
                $result = (java.rmi.Remote) in.readObject();
            } finally {
                ref.done(call);
            }
            return $result;
        } catch (java.lang.Exception e) {
            throw new java.rmi.UnexpectedException("undeclared checked exception", e);
        }
    }
}