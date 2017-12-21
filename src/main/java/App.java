import com.alibaba.fastjson.JSONObject;
import com.hai.ws.api.*;
import com.hai.ws.intercepter.AddAuthHeaderIntercepter;
import com.hai.ws.service.HelloWorldImplService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * HelloWorld WebService with Spring Test
 * Created by Administrator on 2017/12/13.
 */
public class App {

    HelloWorldImplService helloWorldService = null;
    IHelloWorld helloWorld = null;
    Client client = null;


    @Before
    public void before() {
        helloWorldService = new HelloWorldImplService();
        helloWorld = helloWorldService.getHelloWorldImplPort();
    }

    public synchronized void initClient() {
        if (null == client) {
            client = ClientProxy.getClient(helloWorld);
        }
    }

    public void intercept() {
        intercept("hai", "123456");
    }

    public void intercept(String username, String password) {
        initClient();

        //add sys intercepter
        client.getInInterceptors().add(new LoggingInInterceptor());
        client.getOutInterceptors().add(new LoggingOutInterceptor());

        //add custom intercepter for out intercepter
        client.getOutInterceptors().add(new AddAuthHeaderIntercepter(username, password));
    }

    @Test
    public void say() {
        String result = helloWorld.say("hai");
        System.out.println("result: " + result);
    }

    //测试复杂类型
    @Test
    public void getRoleByUser() {
        User user = new User();
        user.setId(1);
        user.setUserName("java1234");
//        user.setUserName("jack");
        user.setPassword("123456");

        List<Role> roles = helloWorld.getRoleByUser(user);
        for (Role role : roles) {
            System.out.println("role id:\t" + role.getId());
            System.out.println("role name:\t" + role.getName());
            System.out.println();
        }
    }

    //测试拦截器-自定义拦截器
    @Test
    public void getRoles() {
        intercept();
//        intercept("hai","11");
        MyRoleArray roleArray = helloWorld.getRoles();
        List<MyRole> roles = roleArray.getItem();
        System.out.println("helloWorld.getRoles result:\n" + JSONObject.toJSONString(roles, true));
    }
}
