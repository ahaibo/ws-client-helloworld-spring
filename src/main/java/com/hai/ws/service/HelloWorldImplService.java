package com.hai.ws.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import com.hai.ws.api.IHelloWorld;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2017-12-21T19:25:24.848+08:00
 * Generated source version: 3.2.1
 * 
 */
@WebServiceClient(name = "HelloWorldImplService", 
                  wsdlLocation = "http://localhost:8080/ws/helloWorld?wsdl",
                  targetNamespace = "http://service.ws.hai.com/") 
public class HelloWorldImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.ws.hai.com/", "HelloWorldImplService");
    public final static QName HelloWorldImplPort = new QName("http://service.ws.hai.com/", "HelloWorldImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/ws/helloWorld?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(HelloWorldImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/ws/helloWorld?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public HelloWorldImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public HelloWorldImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWorldImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public HelloWorldImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public HelloWorldImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public HelloWorldImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns IHelloWorld
     */
    @WebEndpoint(name = "HelloWorldImplPort")
    public IHelloWorld getHelloWorldImplPort() {
        return super.getPort(HelloWorldImplPort, IHelloWorld.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IHelloWorld
     */
    @WebEndpoint(name = "HelloWorldImplPort")
    public IHelloWorld getHelloWorldImplPort(WebServiceFeature... features) {
        return super.getPort(HelloWorldImplPort, IHelloWorld.class, features);
    }

}
