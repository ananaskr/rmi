package jndi.client;

import javax.naming.Context;
import javax.naming.InitialContext;

public class client {
    public static void main(String[] args) throws Exception{
        //ldap://127.0.0.1:1389/ExecTest
        String uri = "rmi://127.0.0.1:1099/aa";
        Context ctx = new InitialContext();
        ctx.lookup(uri);

    }
}