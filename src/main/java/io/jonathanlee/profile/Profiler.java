package io.jonathanlee.profile;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Profiler implements InvocationHandler {

    private long timeSnapshot;

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        this.timeSnapshot = System.currentTimeMillis();

        return method.invoke(o, objects);
    }

}
