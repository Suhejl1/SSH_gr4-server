package com.sshproject.bookstore.Service;

import java.util.List;

public interface AuthorizationExtracterServiceInterface {
    int getAbilityIdFromHTTPREquest(String method, String endpoint, String verb);

    List<Integer> getRoleIdFromAbilityId(int abilityId);

}
