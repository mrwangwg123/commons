package com.wave.android.commons.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射执行方法
 */
public class RefInvokUtils {

    /**
     * 调用 被某个注解修饰的方法
     * @param obj
     * @param annotationClass
     */
    public static void callAnnotation(Object obj, Class annotationClass) {
        Method[] declaredMethods = obj.getClass().getDeclaredMethods();
        for (Method m : declaredMethods
        ) {
            m.setAccessible(true);
            boolean annotationPresent = m.isAnnotationPresent(annotationClass);
            if (annotationPresent) {
                try {
                    m.invoke(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
