package com.sshproject.bookstore.Service;

import java.util.List;

public interface AuthorizationExtracterServiceInterface {
    int getAbilityIdFromHTTPREquest(String method, String endpoint);


    List<Integer> getRoleIdFromAbilityId(int abilityId);

    boolean checkVaryingParams(String method,String endpoint) throws NoSuchFieldException, IllegalAccessException;

}
