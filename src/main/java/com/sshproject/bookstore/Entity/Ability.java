package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ability {

    public Ability(String modelName, String verb, String field){
        this.modelName = modelName;
        this.verb = verb;
        this.field = field;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model_name")
    private String modelName;

    private String verb;
    private String field;


}
