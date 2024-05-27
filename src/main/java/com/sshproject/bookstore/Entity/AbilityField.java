package com.sshproject.bookstore.Entity;

import java.lang.reflect.Field;

public class AbilityField {
    private final static String id = "int";
    private final static String userId = "int";

    private final static String bookId="int";

    private final static String newQuantity = "int";

    private final static String userPaymentMethodId = "int";

    private final static String reviewId = "int";

    private final static String code = "String";

    private final static String tag = "String";

    private final static String paymentTypeId = "int";

    private final static String email = "String";


    //Retrieve value of field using reflection
    public static String getValue(String propertyName) throws NoSuchFieldException, IllegalAccessException {
        Field field = AbilityField.class.getDeclaredField(propertyName);
        field.setAccessible(true);
        return (String) field.get(null);
    }

}
