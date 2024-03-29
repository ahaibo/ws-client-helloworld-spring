package com.hai.ws.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2017-12-21T19:25:24.785+08:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://api.ws.hai.com/", name = "IHelloWorld")
@XmlSeeAlso({ObjectFactory.class})
public interface IHelloWorld {

    @WebMethod
    @RequestWrapper(localName = "getRoles", targetNamespace = "http://api.ws.hai.com/", className = "com.hai.ws.api.GetRoles")
    @ResponseWrapper(localName = "getRolesResponse", targetNamespace = "http://api.ws.hai.com/", className = "com.hai.ws.api.GetRolesResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.hai.ws.api.MyRoleArray getRoles();

    @WebMethod
    @RequestWrapper(localName = "say", targetNamespace = "http://api.ws.hai.com/", className = "com.hai.ws.api.Say")
    @ResponseWrapper(localName = "sayResponse", targetNamespace = "http://api.ws.hai.com/", className = "com.hai.ws.api.SayResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String say(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @RequestWrapper(localName = "getRoleByUser", targetNamespace = "http://api.ws.hai.com/", className = "com.hai.ws.api.GetRoleByUser")
    @ResponseWrapper(localName = "getRoleByUserResponse", targetNamespace = "http://api.ws.hai.com/", className = "com.hai.ws.api.GetRoleByUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.hai.ws.api.Role> getRoleByUser(
        @WebParam(name = "arg0", targetNamespace = "")
        com.hai.ws.api.User arg0
    );
}
