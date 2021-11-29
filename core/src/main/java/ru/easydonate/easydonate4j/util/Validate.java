package ru.easydonate.easydonate4j.util;

import java.util.Collection;
import java.util.Map;

public final class Validate {

    public static void notNull(Object object, String name) {
        if(object == null)
            throw new IllegalArgumentException(String.format("'%s' cannot be null!", name));
    }

    public static void notEmpty(String object, String name) {
        if(object == null || object.isEmpty())
            throw new IllegalArgumentException(String.format("'%s' cannot be empty or null!", name));
    }

    public static void notEmpty(Collection<?> object, String name) {
        if(object == null || object.isEmpty())
            throw new IllegalArgumentException(String.format("'%s' cannot be empty or null!", name));
    }

    public static void notEmpty(Map<?, ?> object, String name) {
        if(object == null || object.isEmpty())
            throw new IllegalArgumentException(String.format("'%s' cannot be empty or null!", name));
    }

    public static void isTrue(boolean condition, String message, Object... args) {
        if(!condition)
            throw new IllegalArgumentException(String.format(message, args));
    }

    public static void isFalse(boolean condition, String message, Object... args) {
        if(condition)
            throw new IllegalArgumentException(String.format(message, args));
    }
    
}
