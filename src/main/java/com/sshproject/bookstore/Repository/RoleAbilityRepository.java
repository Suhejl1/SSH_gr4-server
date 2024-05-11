package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.RoleAbility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleAbilityRepository extends JpaRepository<RoleAbility,Integer> {
    List<RoleAbility> findByAbilityId(int abilityId);
    //We use the ability id extracted from ability repository to get the roleability object
    //After that we extract the role id from it
    // We then compare the role id of user with role id extracted, if they are the same, user is authorized
}
