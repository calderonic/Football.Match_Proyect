package com.football.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.football.annotations.AuditAction;
import com.football.annotations.Sensitive;

public class ReflectionUtils {
    public static void inspect(Object obj) {

        Class<?> clazz = obj.getClass();
        System.out.println("Inspecting: " + clazz.getSimpleName());

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            try {
                Object value = field.get(obj);

                if (field.isAnnotationPresent(Sensitive.class)) {
                    Sensitive ann = field.getAnnotation(Sensitive.class);
                    System.out.println(field.getName() + ": " + ann.mask());
                } else {
                    System.out.println(field.getName() + ": " + value);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(AuditAction.class)) {
                System.out.println("Audit method: " + method.getName());
            }
        }
    }
}
