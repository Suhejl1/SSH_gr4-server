INSERT INTO ability(id,model_name,verb,field) VALUES(1,"POST", "/api/v1/books","all");
INSERT INTO ability(id,model_name,verb,field) VALUES(2,"GET", "/api/v1/users","all");
INSERT INTO ability(id,model_name,verb,field) VALUES(3,"POST", "/api/v1/books/add","all");
INSERT INTO ability(id,model_name,verb,field) VALUES(4,"DELETE", "/api/v1/books","all");
INSERT INTO ability(id,model_name,verb,field) VALUES(5,"POST", "/api/v1/publisher","all");

INSERT INTO ability(id,model_name,verb,field) VALUES(6,"POST", "/api/v1/inventory","all");
INSERT INTO ability(id,model_name,verb,field) VALUES(7,"POST", "/api/v1/genre","all");
INSERT INTO ability(id,model_name,verb,field) VALUES(8,"POST", "/api/v1/discount","all");
INSERT INTO ability(id,model_name,verb,field) VALUES(9,"POST", "/api/v1/booktag","all");
INSERT INTO ability(id,model_name,verb,field) VALUES(10,"POST", "/api/v1/authors","all");

INSERT INTO ability(id,model_name,verb,field) VALUES(12,"PUT", "/api/v1/faq","/id");
INSERT INTO ability(id,model_name,verb,field) VALUES(14,"PUT", "/api/v1/books","/id");
INSERT INTO ability(id,model_name,verb,field) VALUES(15,"POST", "/api/v1/userpaymentmethods","all");
INSERT INTO ability(id,model_name,verb,field) VALUES(16,"DELETE", "/api/v1/publisher","/id");
INSERT INTO ability(id,model_name,verb,field) VALUES(18,"DELETE", "/api/v1/inventory","/id");

INSERT INTO ability(id,model_name,verb,field) VALUES(19,"DELETE", "/api/v1/genre","/id");
INSERT INTO ability(id,model_name,verb,field) VALUES(20,"DELETE", "/api/v1/authors","/id");
INSERT INTO ability(id,model_name,verb,field) VALUES(21,"DELETE", "/api/v1/users","/id");
INSERT INTO ability(id,model_name,verb,field) VALUES(22,"DELETE", "/api/v1/payment_type","/paymentTypeId");
INSERT INTO ability(id,model_name,verb,field) VALUES(24,"POST", "/api/v1/payment_type","all");

INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,1);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,2);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,3);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,4);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,5);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,6);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,7);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,8);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,9);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,10);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,12);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,14);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,15);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,16);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,18);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,19);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,20);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,21);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,22);
INSERT INTO role_ability_relationship(role_id, ability_id) VALUES(1,24);

