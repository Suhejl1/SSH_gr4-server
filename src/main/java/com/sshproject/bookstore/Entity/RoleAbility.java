package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "role_ability_relationship")
public class RoleAbility {
    @EmbeddedId
    private RoleAbilityId id;

    @ManyToOne
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "abilityId", insertable = false, updatable = false)
    private Ability ability;

    public RoleAbilityId getRoleAbilityID() {
        return id;
    }
    public void setRoleAbilityId(RoleAbilityId id) {
        this.id = id;
    }

}


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
class RoleAbilityId implements Serializable {

    @Column(name = "roleId")
    private int roleId;

    @Column(name = "abilityId")
    private int abilityId;

    // Constructors, getters, and setters
}