package ru.soknight.easydonate.sdk.v2.util;

public class Validate {

    public static void isNotNull(String param, Object object) {
        if(object == null)
            throw new IllegalArgumentException("'" + param + "' cannot be null!");
    }
    

    public static void isNotNegative(String param, int number) {
        if(number < 0)
            throw new IllegalArgumentException("'" + param + "' cannot be lower than 0!");
    }
    
}
