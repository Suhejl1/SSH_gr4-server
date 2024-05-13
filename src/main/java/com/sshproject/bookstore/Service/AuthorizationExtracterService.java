package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Ability;
import com.sshproject.bookstore.Entity.RoleAbility;
import com.sshproject.bookstore.Repository.AbilityRepository;
import com.sshproject.bookstore.Repository.RoleAbilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthorizationExtracterService implements AuthorizationExtracterServiceInterface{
    private final AbilityRepository abilityRepository;

    private final RoleAbilityRepository roleAbilityRepository;

    @Override
    public int getAbilityIdFromHTTPREquest(String method, String endpoint, String verb) {
        Optional<Ability> optAbility = abilityRepository.findByModelNameAndVerbAndField(method,endpoint,verb);
        if (optAbility.isPresent()){
            Ability ability = optAbility.get();
            return ability.getId();
        }
        return -1;
    }

    @Override
    public List<Integer> getRoleIdFromAbilityId(int abilityId) {
        List<RoleAbility> roleAbilityList = roleAbilityRepository.findByAbilityId(abilityId);
        List<Integer> roleIds = new ArrayList<>();
        for(RoleAbility ra : roleAbilityList){
            roleIds.add(ra.getRole().getId());
        }
        return roleIds;
    }


}
