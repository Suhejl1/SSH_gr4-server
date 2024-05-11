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
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "ability_id", insertable = false, updatable = false)
    private Ability ability;
}


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
class RoleAbilityId implements Serializable {

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "ability_id")
    private int abilityId;

    // Constructors, getters, and setters
}