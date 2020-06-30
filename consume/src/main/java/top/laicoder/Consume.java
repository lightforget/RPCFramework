package top.laicoder;

import top.laicoder.api.Test;
import top.laicoder.http.HttpClient;
import top.laicoder.http.Invocation;

/**
 * @author jx
 * @date 2020/6/29 21:39
 */
public class Consume {

    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        Invocation invocation = new Invocation(Test.class.getName(), "sayHello", new Class[]{String.class}, new Object[]{"laicoder"});
        String result = client.send("localhost", 8080, invocation);
        System.out.println(result);
    }
}
