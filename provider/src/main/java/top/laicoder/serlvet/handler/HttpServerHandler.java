package top.laicoder.serlvet.handler;

import top.laicoder.LocalRegister;
import top.laicoder.http.Invocation;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jx
 * @date 2020/6/29 20:44
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp){
        // 处理请求和返回结果
        ServletInputStream inputStream = null;
        try {
            inputStream = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);

            Invocation invocation = (Invocation) ois.readObject();
            Class implClass = LocalRegister.get(invocation.getInterfaceName());

            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            Object result = method.invoke(implClass.newInstance(), invocation.getParams());

            ServletOutputStream outputStream = resp.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(result);

            oos.flush();
            oos.close();

            ois.close();


        } catch (IOException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
