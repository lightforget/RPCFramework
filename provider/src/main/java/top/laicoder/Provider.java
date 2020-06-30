package top.laicoder;

import framework.URL;
import top.laicoder.api.Test;
import top.laicoder.impl.TestImpl;
import top.laicoder.server.HttpServer;

/**
 * @author jx
 * @date 2020/6/28 16:39
 */
public class Provider {
    public static void main(String[] args) {
        //本地注册
        // {服务名字：实现类}
        LocalRegister.register(Test.class.getName(), TestImpl.class);

        //远程注册
        //{服务名：List<URL>}
        URL url = new URL("localhost", 8080);
        RemoteMapRegister.register(Test.class.getName(), url);
        //启动Tomcat
        HttpServer.start("localhost", 8080);
    }
}
