package com.soa;

import org.jboss.ejb3.annotation.SecurityDomain;
import org.jboss.ws.api.annotation.AuthMethod;
import org.jboss.ws.api.annotation.TransportGuarantee;
import org.jboss.ws.api.annotation.WebContext;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by redi on 2015-04-13.
 */

@Stateless
@WebService(name="Authorization", portName = "ExamplePort", targetNamespace = "http://localhost:8080/ws")
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
@SecurityDomain("JBossWS")
@RolesAllowed("AdminRole")
@WebContext(transportGuarantee = TransportGuarantee.NONE, secureWSDLAccess = true, authMethod = AuthMethod.BASIC)
public class Secured {

    @WebMethod
    public String hello(String name){
        return "Hello " + name;
    }

//    // Inject the Session Context
//    @Resource
//    private SessionContext ctx;
//
//    /**
//     * Secured EJB method using security annotations
//     */
//    public String getSecurityInfo() {
//        // Session context injected using the resource annotation
//        Principal principal = ctx.getCallerPrincipal();
//        return principal.toString();
//    }
//}
}
