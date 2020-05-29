# Migration Part (run this by itself first, THEN run the app, then the seeder part)

DROP DATABASE IF EXISTS seedr_db;
CREATE DATABASE seedr_db;

USE seedr_db;

Drop USER IF EXISTS seedr_user@localhost;
CREATE USER seedr_user@localhost IDENTIFIED BY '*BlackKitty5';
GRANT ALL ON seedr_db.* TO seedr_user@localhost;


#       ------------------------        Seeder Part

# USERS TABLE - TEST DATA
INSERT INTO users (id, first_name, last_name, username, email, password, zipcode, is_admin, email_updates)
VALUE
(1, 'Kate', 'McKinney', 'katmck14', 'katmck14@gmail.com', 'password', 78240, true, true);

# GARDENS TABLE - TEST DATA
# DELETE FROM gardens WHERE id = 1;
INSERT INTO gardens (id, user_id, garden_name, created, updated)
VALUE
(1, 1, 'Kate Garden', '2020-05-27', null);

# PLANTS TABLE
INSERT INTO plants (id, plant_name, API_id)
VALUES
(1, 'Arugula', '550144506665350003000000'),
(2, 'Asparagus', '54afdda33166630002400600'),
(3, 'Basil', '543c216c3938620002020000'),
(4, 'Beet', '5928f1524f60500004000071'),
(5, 'Bell Pepper', '59b0a4ac4dd0a1000400003b'),
(6, 'Broccoli', '54afdefe3166630002990900'),
(7, 'Brussels Sprout', '54afdf033166630002ae0900'),
(8, 'Cabbage', '542e9dce63313600020f1300'),
(9, 'Carrot', '551ddaf53938340003580000'),
(10, 'Cauliflower', '54afdf023166630002a90900'),
(11, 'Celery', '54afdd0531666300022a0400'),
(12, 'Chives', '54afdca231666300029a0200'),
(13, 'Cilantro', '54afe3793166630002951100'),
(14, 'Cucumber', '54afe4603166630002361300'),
(15, 'Dill', '54afdce83166630002c60300'),
(16, 'Eggplant', '5928ef4aafa29a0004000012'),
(17, 'Fennel', '58c621067c577b0004000003'),
(18, 'Garlic', '54afdca13166630002980200'),
(19, 'Green Bean', '551dbea13765620003320000'),
(20, 'Green Onion', '58c4e73aa264aa0004000014'),
(21, 'Horseradish', '55aebae562336400034f0000'),
(22, 'Jalapeno', '54f1143a62383300031c0000'),
(23, 'Lavender', '57e814c0b371030003000042'),
(24, 'Lettuce', '544c88bd3432630002000000'),
(25, 'Mint', '58cee0a22c21f10004000016'),
(26, 'Okra', '542e9c226331360002030f00'),
#     white onion
(27, 'Onion', '58cf37cbbaf920000400005e'),
(28, 'Oregano', '5eb9927ee22272000466b309'),
(29, 'Parsley', '551ddf2b39383400035b0000'),
(30, 'Parsnip', '58c9bc894fc06a000400003e'),
(31, 'Radish', '542e9e716331360002ce1300'),
(32, 'Rutabaga', '54afdefc3166630002920900'),
(33, 'Sage', '58e32ba8ac29940004000082'),
(34, 'Savoy Cabbage', '5935a923c75bee0004000008'),
(35, 'Soybean', '576b904e92500900030000b2'),
(36, 'Spinach', '542e9ae26331360002300b00'),
(37, 'Strawberry', '54f578dc3361300003040000'),
(38, 'Swiss Chard', '54afde9c3166630002d50800'),
(39, 'Thyme', '58e32ad1ac2994000400007d'),
(40, 'Tomato', '54bda00e3961370003150400'),
(41, 'Turnip', '54afdef93166630002890900'),
(42, 'Zucchini', '54afe4673166630002411300'),
(43, 'Kohlrabi', '54afdf013166630002a60900'),
(44, 'Collard Greens', '54afdf003166630002a10900'),
(45, 'Lima Bean', '5930573b40cd86000400000f'),
(46, 'Chamomile', '550c829c30623100033f0000'),
(47, 'Lemon Balm', '54bd4d0b6239330003de0200'),
(48, 'Coriander', '54afe37a3166630002961100'),
(49, 'Leek', '54afdc7f31666300023d0200'),
(50, 'Mesclun', '5dc64fb22db8d000045ff82b');

# SQUARES TABLE - TEST DATA
INSERT INTO squares (id, garden_id, square_num, plant_id, plant_date)
    VALUE
    (1, 1, 5, 1, '2020-05-28');
