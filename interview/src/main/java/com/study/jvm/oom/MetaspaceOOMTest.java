package com.study.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
public class MetaspaceOOMTest {

    // 静态内部类
    static class OOMTest {
    }

    public static void main(String[] args) {
        int i = 0; // 模拟计数多少次以后发生异常

        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
                            throws Throwable {
                        return methodProxy.invokeSuper(o, objects);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable e) { // 注意这里不是Exception
            System.out.println("***多少次后发生异常，i = " + i);
            e.printStackTrace();
        }
    }
}