-- ADD a the role_id column in the users table
ALTER TABLE users
ADD COLUMN role_id INT;


-- Make the role_id column as a foreing key from the role table
ALTER TABLE users
ADD CONSTRAINT fk_role_id
FOREIGN KEY (role_id) REFERENCES role(id);