package top.laicoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jx
 * @date 2020/6/29 21:20
 */
public class LocalRegister {
    private static Map<String, Class> map = new HashMap<String, Class>();
    public static void register(String interfaceName, Class implClass){
        map.put(interfaceName, implClass);
    }

    public static Class get(String interfaceName){
        return map.get(interfaceName);
    }
}
