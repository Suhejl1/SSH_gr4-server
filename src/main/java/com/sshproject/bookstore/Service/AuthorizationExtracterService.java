package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Ability;
import com.sshproject.bookstore.Entity.AbilityField;
import com.sshproject.bookstore.Entity.RoleAbility;
import com.sshproject.bookstore.Entity.User;
import com.sshproject.bookstore.Helpers.StringManipulators;
import com.sshproject.bookstore.Repository.AbilityRepository;
import com.sshproject.bookstore.Repository.RoleAbilityRepository;
import com.sshproject.bookstore.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class AuthorizationExtracterService implements AuthorizationExtracterServiceInterface{
    private final AbilityRepository abilityRepository;

    private final RoleAbilityRepository roleAbilityRepository;

    private final UserRepository userRepository;



    @Override
    public int getAbilityIdFromHTTPREquest(String method, String endpoint) {
        Optional<Ability> optAbility = abilityRepository.findByModelNameAndVerb(method,endpoint);
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

    @Override
    public boolean checkVaryingParams(String method,String endpoint) throws NoSuchFieldException, IllegalAccessException {
        String fieldDB = abilityRepository.getByEndpointPrefix(method,endpoint);
        if (fieldDB==null){
            return true;
        }

        //api/v1/faq/3


        System.out.println(fieldDB);
        if(fieldDB.equals("all")){
            return true;
        }

        String[] paths = StringManipulators.splitPath(fieldDB);
        for(int i=0;i<paths.length;i++){
            paths[i] = AbilityField.getValue(paths[i]);
            System.out.println("Path member " + (i+1) + " -- " + paths[i]);
        }
        List<String> prefixes = StringManipulators.extractSubstring(endpoint, fieldDB);
        for(String s : prefixes){
            System.out.println("Prefixes member " + "-- " + s);
        }
        for (int i = 0; i < paths.length; i++) {
            System.out.println();
            if (Objects.equals(paths[i], "int")) {
                try {
                    int num = Integer.parseInt(prefixes.get(i));
                    if(num<=0){
                        throw new Exception("Not valid!");
                    }
                } catch (Exception e) {
                    System.out.println("Cannot parse string to integer");
                    return false;
                }
            }else if(Objects.equals(paths[i],"String") && prefixes.get(i) != null){
                System.out.println("String check passed");
            }
            return true;
        }
        return false;
    }


    public String getCorrectEndpoint(String method, String endpoint){
        String fieldDB = abilityRepository.getByEndpointPrefix(method,endpoint);

        if (fieldDB==null){
            return endpoint;
        }else if(fieldDB.equals("all")){
            return endpoint;
        }else{
            return StringManipulators.getSubstringWithoutSlashes(fieldDB,endpoint);
        }
    }

}
