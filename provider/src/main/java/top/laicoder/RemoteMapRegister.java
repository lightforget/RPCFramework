package top.laicoder;

import framework.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jx
 * @date 2020/6/29 21:25
 */
public class RemoteMapRegister {
    private final static Map<String, List<URL>> REGISTER =new HashMap<>();

    public static void register(String interfaceName, URL url){
        if(REGISTER.get(interfaceName) == null){
            List<URL> urls = new ArrayList<>();
            urls.add(url);
            REGISTER.put(interfaceName, urls);
        }else{
            REGISTER.get(interfaceName).add(url);
        }
    }

    public List<URL> get(String interfaceName){
        return REGISTER.get(interfaceName);
    }
}
