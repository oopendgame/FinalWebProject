USE finalProject;

DROP TABLE IF EXISTS admins;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS admins (
    admin_id int not null auto_increment,
    user_id int,
    
    primary key(admin_id),
    FOREIGN KEY (user_id) REFERENCES userInfo(user_id)
);


INSERT INTO admins(user_id) VALUES
(1),
(2),
(3);o");