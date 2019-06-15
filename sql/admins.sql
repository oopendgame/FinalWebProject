USE finalProject;

DROP TABLE IF EXISTS admins;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS admins (
    admin_id int not null auto_increment,
    admin_name varchar(50) not null unique,
    
    primary key(admin_id)
);




INSERT INTO admins (admin_name) VALUES
("anamaria"),
("nino");