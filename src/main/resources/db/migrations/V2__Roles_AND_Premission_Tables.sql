CREATE TABLE IF NOT EXISTS roles (
    id INTEGER,
    name VARCHAR(250),
    description VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS premissions (
    id INTEGER,
    name VARCHAR(250),
    description VARCHAR(250),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS rolesAndPremssionsMapping(
    role_id INTEGER,
    premission_id INTEGER,
    PRIMARY KEY (role_id, premission_id),
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (premission_id) REFERENCES premissions(id)
);

