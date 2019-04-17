package com.fyj.testokhttp.utils;

import java.lang.reflect.ParameterizedType;

public class GenericsUtil {
    public static <T> T getGenericInstance(Object o,int i){
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return  null ;
    }
}
