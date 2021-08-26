DROP SCHEMA userservice;
CREATE SCHEMA userservice;

USE userservice;

CREATE TABLE IF NOT EXISTS `userservice`.`user`(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS `userservice`.`role`(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS `userservice`.`user_role`(
    user_id INT UNSIGNED NOT NULL,
    role_id INT UNSIGNED NOT NULL,
    PRIMARY KEY(user_id, role_id),
    CONSTRAINT `fk_user_role_user_id`
        FOREIGN KEY(user_id)
        REFERENCES `userservice`.`user`(id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT `fk_user_rol_rol_id`
            FOREIGN KEY(role_id)
            REFERENCES `userservice`.`role`(id)
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
);