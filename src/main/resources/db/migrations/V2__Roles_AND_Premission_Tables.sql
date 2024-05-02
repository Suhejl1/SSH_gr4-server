CREATE TABLE IF NOT EXISTS role (
    id INTEGER,
    name VARCHAR(250),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ability (
    id INTEGER,
    model_name VARCHAR(250),
    verb VARCHAR(250),
    field VARCHAR(250),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Role_Ability_Relationship(
    role_id INTEGER,
    ability_id INTEGER,
    PRIMARY KEY (role_id, ability_id),
    FOREIGN KEY (role_id) REFERENCES role(id),
    FOREIGN KEY (ability_id) REFERENCES ability(id)
);

