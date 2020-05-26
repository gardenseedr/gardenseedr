DROP DATABASE IF EXISTS seedr_db;
CREATE DATABASE seedr_db;

USE seedr_db;

Drop USER IF EXISTS seedr_user@localhost;
CREATE USER seedr_user@localhost IDENTIFIED BY '*BlackKitty5';
GRANT ALL ON seedr_db.* TO seedr_user@localhost;


# USERS TABLE - TEST DATA
INSERT INTO users (id, first_name, last_name, username, email, password, zipcode, is_admin, email_updates)
VALUE
(1, 'Kate', 'McKinney', 'katmck14', 'katmck14@gmail.com', 'password', 78240, true, true);

# GARDENS TABLE - TEST DATA
INSERT INTO gardens (id, user_id, garden_name, created, updated)
VALUE
(1, 1, 'Kate Garden', '01/14/1996','01/14/1997');

# SQUARES TABLE - TEST DATA
INSERT INTO squares (id, garden_id, square_num, plant_id, plant_date)
VALUE
(1, 1, 'A3', 1, '01/14/1996');

# PLANTS TABLE ----------------------------- THIS NEEDS TO HAVE ALL 100 OF THE TOP 100 PLANT LIST
INSERT INTO plants (id, plant_name, API_id)
VALUE
(1, 'Arugula', '12A3B45');