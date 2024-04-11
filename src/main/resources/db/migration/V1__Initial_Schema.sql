CREATE TABLE IF NOT EXISTS USERS (
id INTEGER AUTO_INCREMENT,
email_address VARCHAR(250),
password VARCHAR(250),
PRIMARY KEY (id)
);

 CREATE TABLE IF NOT EXISTS countries (
id INTEGER AUTO_INCREMENT,
country_name VARCHAR(250),
PRIMARY KEY (id)
);


 CREATE TABLE IF NOT EXISTS addresses (
id INTEGER AUTO_INCREMENT,
street_number INTEGER,
address_line1 VARCHAR(250),
address_line2 VARCHAR(250),
city VARCHAR(250),
region VARCHAR(250),
postal_code VARCHAR(250),
country_id INTEGER,
PRIMARY KEY (id),
FOREIGN KEY (country_id) REFERENCES countries(id)
);

 CREATE TABLE IF NOT EXISTS user_addresses (
user_id INTEGER,
address_id INTEGER,
is_default BOOLEAN,
PRIMARY KEY (user_id, address_id),
FOREIGN KEY (user_id) REFERENCES users(id),
FOREIGN KEY (address_id) REFERENCES addresses(id)
);

 CREATE TABLE IF NOT EXISTS payment_type (
id INTEGER AUTO_INCREMENT,
value VARCHAR(250),
PRIMARY KEY (id)
);

 CREATE TABLE IF NOT EXISTS users_payment_methods (
id INTEGER AUTO_INCREMENT,
user_id INTEGER,
payment_type_id INTEGER,
provider VARCHAR(250),
account_number VARCHAR(250),
expire_date DATE,
is_deffault BOOLEAN,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES users(id),
FOREIGN KEY (payment_type_id) REFERENCES payment_type(id)
);


CREATE TABLE IF NOT EXISTS shoping_cart (
id INTEGER AUTO_INCREMENT,
user_id INTEGER,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS shipping_methods (
id INTEGER AUTO_INCREMENT,
name VARCHAR(250),
price DECIMAL,
PRIMARY KEY (id)
);

 CREATE TABLE IF NOT EXISTS order_status (
id INTEGER AUTO_INCREMENT,
status VARCHAR(250),
PRIMARY KEY (id)
);

 CREATE TABLE IF NOT EXISTS shop_orders (
id INTEGER AUTO_INCREMENT,
user_id INTEGER,
order_date DATE,
payment_method_id INTEGER,
shipping_address_id INTEGER,
order_total DECIMAL,
order_status_id INTEGER,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES users(id),
FOREIGN KEY (payment_method_id) REFERENCES users_payment_methods(id),
FOREIGN KEY (shipping_address_id) REFERENCES addresses(id)
);

 CREATE TABLE IF NOT EXISTS authors (
id INTEGER AUTO_INCREMENT,
name VARCHAR(250),
nationality VARCHAR(250),
birth_date DATE,
PRIMARY KEY (id)
);

 CREATE TABLE IF NOT EXISTS publishers(
id INTEGER AUTO_INCREMENT,
name VARCHAR(250),
location VARCHAR(250),
PRIMARY KEY (id)
);


 CREATE TABLE IF NOT EXISTS genres (
id INTEGER AUTO_INCREMENT,
name VARCHAR(250),
PRIMARY KEY (id)
);

 CREATE TABLE IF NOT EXISTS discounts (
id INTEGER AUTO_INCREMENT,
discount_code VARCHAR(250),
discount_percentage DECIMAL,
expire_date DATE,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS inventory (
id INTEGER AUTO_INCREMENT,
quantity INTEGER,
date_added DATE,
date_modified DATE,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS faq (
id INTEGER AUTO_INCREMENT,
question VARCHAR(500),
answer VARCHAR(500),
PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS books (
id INTEGER AUTO_INCREMENT,
title VARCHAR(250),
author_id INTEGER,
isbn VARCHAR(250),
publisher INTEGER,
year YEAR,
price DECIMAL,
image BLOB,
description VARCHAR(500),
inventory_id INTEGER,
PRIMARY KEY (id),
FOREIGN KEY (author_id) REFERENCES authors(id),
FOREIGN KEY (publisher) REFERENCES publishers(id),
FOREIGN KEY (inventory_id) REFERENCES inventory(id)
);


CREATE TABLE IF NOT EXISTS favourties (
id INTEGER AUTO_INCREMENT,
user_id INTEGER,
book_id INTEGER,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES users(id),
FOREIGN KEY (book_id) REFERENCES books(id)
);

CREATE TABLE IF NOT EXISTS books_genres_relationship (
book_id INTEGER,
genres_id INTEGER,
PRIMARY KEY (book_id, genres_id),
FOREIGN KEY (book_id) REFERENCES books(id),
FOREIGN KEY (genres_id) REFERENCES genres(id)
);

CREATE TABLE IF NOT EXISTS book_tags (
id INTEGER AUTO_INCREMENT,
book_id INTEGER,
tag_name VARCHAR(250),
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS wishlist (
id INTEGER AUTO_INCREMENT,
book_id INTEGER,
user_id INTEGER,
PRIMARY KEY (id),
FOREIGN KEY (book_id) REFERENCES books(id),
FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE IF NOT EXISTS order_line (
id INTEGER AUTO_INCREMENT,
product_item_id INTEGER,
order_id INTEGER,
quantity INTEGER,
price DECIMAL,
PRIMARY KEY (id),
FOREIGN KEY (product_item_id) REFERENCES books(id),
FOREIGN KEY (order_id) REFERENCES shop_orders(id)
);

CREATE TABLE IF NOT EXISTS shopping_cart_items (
id INTEGER AUTO_INCREMENT,
cart_id INTEGER,
product_item_id INTEGER,
quantity INTEGER,
PRIMARY KEY (id),
FOREIGN KEY (cart_id) REFERENCES shoping_cart(id),
FOREIGN KEY (product_item_id) REFERENCES books(id)
);

CREATE TABLE IF NOT EXISTS reviews (
id INTEGER AUTO_INCREMENT,
user_id INTEGER,
ordered_book_id INTEGER,
rating_value INTEGER,
comment VARCHAR(250),
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES users(id),
FOREIGN KEY (ordered_book_id) REFERENCES order_line(id)
);