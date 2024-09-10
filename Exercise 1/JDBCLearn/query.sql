DROP TABLE if exists `dbtest`.`user`;

CREATE TABLE `dbtest`.`user` (
	`id` INT NOT NULL auto_increment,
    `username` VARCHAR(50) NULL,
    `email` VARCHAR(50) NULL,
    `fullname` VARCHAR(100) NULL,
    `images` VARCHAR(500) NULL,
    PRIMARY KEY (`id`));    
 