package top.laicoder.impl;

import top.laicoder.api.Test;

/**
 * @author jx
 * @date 2020/6/28 16:38
 */
public class TestImpl implements Test {

    public String sayHello(String name) {
        return "Hello," + name;
    }
}
