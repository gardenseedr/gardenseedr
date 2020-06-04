# Migration Part (run this by itself first, THEN run the app, then the seeder part)

DROP DATABASE IF EXISTS seedr_db;
CREATE DATABASE seedr_db;

USE seedr_db;

Drop USER IF EXISTS seedr_user@localhost;
CREATE USER seedr_user@localhost IDENTIFIED BY '*BlackKitty5';
GRANT ALL ON seedr_db.* TO seedr_user@localhost;


#       ------------------------        Seeder Part

# USERS TABLE - TEST DATA (the password hash is for "pass")
INSERT INTO users (id, first_name, last_name, username, email, password, zipcode, is_admin, email_updates)
VALUE
(1, 'Kate', 'McKinney', 'katmck14', 'katmck14@gmail.com', '$2a$10$6rQQ6qTfqlCwTIXC3HxwuuRQhPGIH88efaPgEb5P9wjrlebWGdmCG', 78240, true, true);

# GARDENS TABLE - TEST DATA
# DELETE FROM gardens WHERE id = 1;
INSERT INTO gardens (id, user_id, garden_name, created, updated)
VALUE
(1, 1, 'Gigert', '2020-05-27', null);

# PLANTS TABLE
INSERT INTO plants (id, plant_name, API_id, pic_file_name)
VALUES
(1, 'Arugula', '550144506665350003000000', 'arugula.svg'),
(2, 'Asparagus', '54afdda33166630002400600', 'asparagus.svg'),
(3, 'Basil', '543c216c3938620002020000', 'basil.svg'),
(4, 'Beet', '5928f1524f60500004000071', 'beet.svg'),
(5, 'Bell Pepper', '59b0a4ac4dd0a1000400003b', 'bellpepper.svg'),
(6, 'Broccoli', '54afdefe3166630002990900', 'broccoli.svg'),
(7, 'Brussels Sprout', '54afdf033166630002ae0900', 'brusselssprout.svg'),
(8, 'Cabbage', '542e9dce63313600020f1300', 'cabbage.svg'),
(9, 'Carrot', '551ddaf53938340003580000', 'carrot.svg'),
(10, 'Cauliflower', '54afdf023166630002a90900', 'cauliflower.svg'),
(11, 'Celery', '54afdd0531666300022a0400', 'celery.svg'),
(12, 'Chives', '54afdca231666300029a0200', 'chives.svg'),
(13, 'Cilantro', '54afe3793166630002951100', 'cilantro.svg'),
(14, 'Cucumber', '54afe4603166630002361300', 'cucumber.svg'),
(15, 'Dill', '54afdce83166630002c60300', 'dill.svg'),
(16, 'Eggplant', '5928ef4aafa29a0004000012', 'eggplant.svg'),
(17, 'Fennel', '58c621067c577b0004000003', 'fennel.svg'),
(18, 'Garlic', '54afdca13166630002980200', 'garlic.svg'),
(19, 'Green Bean', '551dbea13765620003320000', 'greenbean.svg'),
(20, 'Green Onion', '58c4e73aa264aa0004000014', 'greenonion.svg'),
(21, 'Horseradish', '55aebae562336400034f0000', 'horseradish.svg'),
(22, 'Jalapeno', '54f1143a62383300031c0000','jalapeno.svg'),
(23, 'Lavender', '57e814c0b371030003000042', 'lavender.svg'),
(24, 'Lettuce', '544c88bd3432630002000000', 'lettuce.svg'),
(25, 'Mint', '58cee0a22c21f10004000016', 'mint.svg'),
(26, 'Okra', '542e9c226331360002030f00', 'okra.svg'),
(27, 'Onion', '58cf37cbbaf920000400005e', 'onion.svg'),
(28, 'Oregano', '5eb9927ee22272000466b309', 'oregano.svg'),
(29, 'Parsley', '551ddf2b39383400035b0000', 'parsley.svg'),
(30, 'Parsnip', '58c9bc894fc06a000400003e', 'parsnip.svg'),
(31, 'Radish', '542e9e716331360002ce1300', 'radish.svg'),
(32, 'Rutabaga', '54afdefc3166630002920900', 'rutabaga.svg'),
(33, 'Sage', '58e32ba8ac29940004000082', 'sage.svg'),
(34, 'Savoy Cabbage', '5935a923c75bee0004000008', 'savoycabbage.svg'),
(35, 'Soybean', '576b904e92500900030000b2', 'soybean.svg'),
(36, 'Spinach', '542e9ae26331360002300b00', 'spinach.svg'),
(37, 'Strawberry', '54f578dc3361300003040000', 'strawberry.svg'),
(38, 'Swiss Chard', '54afde9c3166630002d50800', 'swisschard.svg'),
(39, 'Thyme', '58e32ad1ac2994000400007d', 'thyme.svg'),
(40, 'Tomato', '54bda00e3961370003150400', 'tomato.svg'),
(41, 'Turnip', '54afdef93166630002890900', 'turnip.svg'),
(42, 'Zucchini', '54afe4673166630002411300', 'zucchini.svg'),
(43, 'Kohlrabi', '54afdf013166630002a60900', 'kohlrabi.svg'),
(44, 'Collard Greens', '54afdf003166630002a10900', 'collardgreens.svg'),
(45, 'Lima Bean', '5930573b40cd86000400000f', 'limabean.svg'),
(46, 'Chamomile', '550c829c30623100033f0000', 'chamomile.svg'),
(47, 'Lemon Balm', '54bd4d0b6239330003de0200', 'lemonbalm.svg'),
(48, 'Coriander', '54afe37a3166630002961100', 'coriander.svg'),
(49, 'Leek', '54afdc7f31666300023d0200', 'leek.svg'),
(50, 'Mesclun', '5dc64fb22db8d000045ff82b', 'mesclun.svg');



# SQUARES TABLE - TEST DATA
INSERT INTO squares (id, garden_id, square_num, plant_id, plant_date, last_watered)
    VALUES
    (1, 1, 5, 1, '2020-05-28','2020-06-01');

# NOTES TABLE - TEST DATA
INSERT INTO notes (id, created, body, square_id)
VALUES
(1, '2020-05-28', 'all the body, such body', 1);

# DON'T USE THIS
UPDATE gardens
SET garden_name = null
    WHERE id = 2;
